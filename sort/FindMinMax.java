package com.seeburger.sort;

public class FindMinMax {
	public static final int ARRAY_SIZE = 100;
	
	public static int[] randomArrayGeneration() {
		int[] arr = new int[ARRAY_SIZE];
		
		for (int i = 0; i < ARRAY_SIZE; i++) {
			arr[i] = ((int)(Math.random()*ARRAY_SIZE+1));
		}
		return arr;
	}
	
	public static int findMin(int[] arr) {
		int minElement = 0;
		for (int i = 0; i < ARRAY_SIZE; i++) {
			if (i == 0) {
				minElement = arr[i];
			}
			if (arr[i] < minElement) {
				minElement = arr[i];
			}
		}
		return minElement;
	}
	
	public static int findMax(int[] arr) {
		int maxElement = 0;
		for (int i = 0; i < ARRAY_SIZE; i++) {
			if (i == 0) {
				maxElement = arr[i];
			}
			if (arr[i] > maxElement) {
				maxElement = arr[i];
			}
		}
		return maxElement;
	}
	
}
