package tasks1104;

import java.util.Arrays;
import java.util.Scanner;

public class Pythagorean {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		do {
			System.out.println("Enter the count of the input numbers: ");
			count = sc.nextInt();
		} while (count <= 0 || count > 100);
		int[] arr = new int[count];
	
		for (int i = 0; i < count; i++) {
			boolean areUnique = true;
			System.out.println("Enter a pythagorean number: ");
			int number = sc.nextInt();
			for (int j = i-1; j > 0 && areUnique; j--) {
				if (arr[i] == arr[j]) {
					areUnique = false;
				}
				if (j == 0 && arr[i] >= 0 && arr[i] < 1000 ) 
					arr[i] = number;
			}
			
		}
		Arrays.sort(arr);
		boolean isPythagoreanNumber = false;
		for (int i = count-1; i > 1; i--) {
			if(arr[i] == Math.sqrt((Math.pow(arr[i-1], 2)) + Math.pow(arr[i-2], 2))) {
				System.out.println(arr[i-1] + " * " + arr[i-1] + " + " + arr[i-2] + " * " + arr[i-2] + " = " + arr[i]);
				isPythagoreanNumber = true;
			}
			if(i == 2 && !isPythagoreanNumber) {
				System.out.println("No");
			}
		}
		sc.close();
	}
}
