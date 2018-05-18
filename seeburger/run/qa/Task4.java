package com.seeburger.qa;

public class Task4 {
	static final int MATRIX_LENGTH = 5;
		
	public static int[][] fillMatrix(int[][] arr) {
        int minCol = 0;  
        int maxCol = MATRIX_LENGTH-1; 
        int minRow = 0;
        int maxRow = MATRIX_LENGTH-1;
        int total = MATRIX_LENGTH*MATRIX_LENGTH;
         
        //fill the matrix with values [1, 25]
        //every iteration is considered to extend the minCol and minRow 
        //and cease the maxCol and maxRow by 1
        for (int value = 1; value <= total; minCol++, minRow++, maxCol--, maxRow--)
        {
        	//iterare rows until it reaches the maxRow
            for (int i = minRow; i <= maxRow; i++)
            {
                arr[i][minCol] = value;                
                value++;
            }
            //iterate cows till it reaches the maxCol, starting from minCol+1, so the element don't duplicate
            for (int i = minCol+1; i <= maxCol; i++) 
            { 
                arr[maxRow][i] = value; 
                value++; 
            } 
            //iterate rows conversely 
            for (int i = maxRow-1; i >= minRow; i--)
            {
                arr[i][maxCol] = value;
                value++;
            }
            //iterate cols conversely
            for (int i = maxCol-1; i >= minCol+1; i--) 
            {
                arr[minRow][i] = value;
                value++;
            }
        }
		return arr;	
	}
	
	public static void print(int[][] arr) {
		for(int i = 0; i < MATRIX_LENGTH; i++) {
	        for(int j = 0; j < arr[i].length; j++) {
	        	if (arr[i][j] < 10) {
	        		System.out.print(" ");
	        	}
	        	System.out.print(arr[i][j] + " ");
	        }
	        System.out.println();
	    }
	}
	
	public static void main(String[] args) {	
		int[][] arr = new int[MATRIX_LENGTH][MATRIX_LENGTH];
		fillMatrix(arr);
		print(arr);
	}

}
