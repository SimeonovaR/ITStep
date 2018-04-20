package com.seeburger.sort;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Files {
	public static void reachBottomOfDirectory(String filePath) {
		File folder = new File(filePath);
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
			if (file.isDirectory() && !file.isHidden()) {
				System.out.println(file.getAbsolutePath());
				reachBottomOfDirectory(file.getAbsolutePath());
			}
		}
	}
	public static String getIp() throws IOException {
		Properties props = new Properties();
		String propsFile = "C:\\Users\\MKA\\Desktop\\properties.props.txt";
		InputStream is = null;
		
		is = new FileInputStream(propsFile);
		props.load(is);
		String properties = props.getProperty("ip_address");
		is.close();
		return properties;
	}
	
	public static void copyFileUsingStream(File source, File dest) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		File.listRoots();
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer,  0 , length);
			}
		} finally {
			is.close();
			os.close();
		}
	}
}
