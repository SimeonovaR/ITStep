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
}
