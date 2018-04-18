package com.seeburger.sort;

public class BubbleSort {
	public static int[] bubble(int[] arr) {
		int count = 0;
		for (count = 0; count < arr.length; count++) {
			boolean isSorted = true;
			for (int index = 0; index < arr.length-1-count; index++) {
				if (arr[index] > arr[index+1]) {
					int temp = arr[index];
					arr[index] = arr[index+1];
					arr[index+1] = temp;
					isSorted = false;
				}
			}
			if (isSorted) {
				System.out.println("There're " + count + " swap iterations that were needed.");
				break;
			}
		}
		
		return arr;
	}
}
