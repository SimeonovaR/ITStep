package com.seeburger.threads;

import java.io.File;
import java.io.IOException;

public class DirectoryContentTransport implements Runnable {
	private File source;
	private File dest;

	public DirectoryContentTransport(File source, File dest) {
		this.source = source;
		this.dest = dest;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				if (!isEmptyDirectory()) {
					this.reachBottomOfDirectory(source.getAbsolutePath());
				}
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			// prevent the exception from swallowing
			Thread.currentThread().interrupt();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public boolean isEmptyDirectory() {
		return (this.source.listFiles().length <= 0);
	}

	private static void moveFiles(File source, File dest) throws IOException {
		// get a list of files in source directory
		File[] files = source.listFiles();
		// for each file in the source directory -> move
		for (File file : files) {
			System.out.println(source + File.separator + file.getName());

			String srcFile = (source + File.separator + file.getName());
			String newDestFile = (dest + File.separator + file.getName());

			File newFile = new File(srcFile);
			// renames the file which is specified
			newFile.renameTo(new File(newDestFile));
		}
	}

	public void reachBottomOfDirectory(String filePath) throws IOException {
		File folder = new File(filePath);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isDirectory() && !file.isHidden() && file.length() > 0) {
				System.out.println(file.getAbsolutePath());
				moveFiles(source, dest);
				this.reachBottomOfDirectory(file.getAbsolutePath());
			} else {
				moveFiles(file.getParentFile(), dest);
			}
		}
	}
}
