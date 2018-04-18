package com.seeburger.run;

import java.io.IOException;

import com.seeburger.sort.BubbleSort;
import com.seeburger.sort.Files;
import com.seeburger.sort.FindMinMax;
import com.seeburger.sort.SelectionSort;
import com.seeburger.sort.Strings;

public class RunApp {
	
	public static void main(String[] args) throws IOException {
		int[] arr = FindMinMax.randomArrayGeneration();
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(FindMinMax.findMin(arr));
		System.out.println(FindMinMax.findMax(arr));
		
		String sub1 = "Task:";
		String sub2 = "Test";
		String sub3 = "all substrings";
		String sub4 = "and return the index";
		System.out.println(Strings.findIndexOfSubstring(sub1, sub2, sub3, sub4));
		
		//int[] arr2 = BubbleSort.bubble(arr);
		//for (int index : arr2) {
		//	System.out.print(index + " ");
		//}
		int[] arr3 = SelectionSort.selection(arr);
		for (int index : arr3) {
			System.out.print(index + " ");
		}
		
		Files.reachBottomOfDirectory("C:\\Autodesk\\AutoCAD_2018_English_Win_32_64bit_wi_en-us");

		String ip = Files.getIp();

		System.out.println(ip);
	}

}
