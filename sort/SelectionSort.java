package com.seeburger.sort;

public class SelectionSort {
	public static int[] selection(int[] arr) {

		for (int begin = 0; begin < arr.length - 1; begin++)
        {
            int min = begin;
            for (int index = begin + 1; index < arr.length; index++) {
                if (arr[min] > arr[index])
                    min = index;
            }
            
   		    int temp = arr[min];
 		    arr[min] = arr[begin];
   		    arr[begin] = temp;
        }
		
		return arr;
	}
}
