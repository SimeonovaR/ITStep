package introductionTasks;

import java.util.Arrays;
import java.util.*;
import java.util.Scanner;

public class LoopsAndArrays {
	public static void task1(int n, int[] arr) {
		for(int i = 0; i < n; i++) {
			if(arr[i] % 2 == 0) {
				System.out.println(0);
			}
			else {
				System.out.println(arr[i]);
			}
		}
	}
	
	public static void task2(int n,int[] arr) {
		for(int i = n-1; i >= 0; i--) {
			System.out.println(arr[i]);
		}
	}
	
	public static void task3(int n, int[] arr) {
		Arrays.sort(arr);
		List<Integer> container = new ArrayList<Integer>();
		boolean flag = true;
		int minElement = arr[0];
		for(int i = 2; i <= minElement; i++) {
			for(int j = 0; j < n && flag; j++) {
				if(arr[j]%i != 0) {
					flag = false;
				}
				else {
					if(j == n-1) {
						container.add(i);
					}
				}
			}
		}
		for(Integer divisor : container) {
			System.out.println(divisor);
		}
	}
	
	public static void task4(int n, int[] arr, int numberToRemove) {		
		for (int i = 0; i < n; i++) {
			if(arr[i] == numberToRemove) {
				for(int j = i; j <= n - 2; j++)
				    arr[j] = arr[j+1];
				n--;
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i] + " ");
		}
	}
	
	public static void task5(int[] arr1, int[] arr2, int n) {
		int[] arr3 = new int[n];
		for(int i = 0; i < n; i++) {
			if(arr1[i] > arr2[i]) {
				arr3[i] = arr1[i];
			}
			else {
				arr3[i] = arr2[i];
			}
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(arr3[i] + ", ");
		}
	}
	
	public static int sumDiag1(int[][] matrix, int n) {
		int sum = 0;
		for(int i = 0; i < n; i++) {
			int j = i;
			sum += matrix[i][j];
		}
		return sum;
	}
	
	public static int sumDiag2(int[][] matrix, int n) {
		int sum = 0;
		for(int i = 0; i < n;) {
			for(int j = n-i-1; j >= 0;) {
				sum += matrix[i][j];
				i++;
				j--;
			}
		}
		return sum;
	}
	
	public static int compareDiagonalSums(int[][] matrix, int n) {
		int sum1 = sumDiag1(matrix, n);
		int sum2 = sumDiag2(matrix, n);
		int max = (sum1 > sum2) ? sum1 : sum2;
		return max;
	}
	
	public static void maxElementOfARow(int[][] matrix, int n) {
		int[] maxElement = new int[n];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] > maxElement[i]) {
					maxElement[i] = matrix[i][j];
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(maxElement[i] + " ");
		}
	}
	
	public static void maxElementOfACol(int[][] matrix, int n) {
		int[] maxElement = new int[n]; 
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[j][i] > maxElement[i]) {
					maxElement[i] = matrix[j][i];
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(maxElement[i] + " ");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("number of elements in the array: ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			System.out.print("arr[" + i + "] = " );
			arr[i] = sc.nextInt();
		}
		int numberToRemove = 4;
		task4(n, arr, numberToRemove);
		sc.close(); 
		int[][] matrix = new int[][] {{0, 1, 2},
                                      {2, 5, 4},
                                      {9, 4, 5}};  
        int maxSumOfDiagonalElements = compareDiagonalSums(matrix, matrix.length);
        System.out.println(maxSumOfDiagonalElements);
        maxElementOfARow(matrix, matrix.length);
        maxElementOfACol(matrix, matrix.length);
	}

}
