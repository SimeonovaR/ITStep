package com.seeburger.sort;

public class Strings {
	public static String findIndexOfSubstring(String sub1, String sub2, String sub3, String sub4) {
		
		String[] str = {sub1, sub2, sub3, sub4};
		int index = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals(sub3)) {
				index = i;
			}
		}
		return ((index != 0) ? "The substring is at index " + index : "The substring is not found");
	}
}
