package tasks;

import java.util.Random;
import java.util.Scanner;

public class Tasks {
	public static final int NUMBER_OF_ELEMENTS = 100;
	private static final int LOTTERY_NUMBERS = 6;

	public static void decToBinary (byte decimal) {
		int[] arr = new int[8];
		int i = 0;
		while (decimal >= 1) {
			arr[i] = ((decimal % 2 == 0) ? 0 : 1);
			decimal /= 2;
			i++;
		}
		
		for (int j = arr.length - 1; j >= 0; j--) {
			System.out.print(arr[j]);
		}
	}
	
	public static void evenAndOddElements (int[] arr) {
		int[] even = new int[NUMBER_OF_ELEMENTS];
		int[] odd = new int[NUMBER_OF_ELEMENTS]; 
		
		int evenIterator = 0;
		int oddIterator = 0; 
		
		for (int i = 0 ; i < NUMBER_OF_ELEMENTS; i++) {
			if (arr[i] % 2 == 0) {
				even[evenIterator] = arr[i];
				evenIterator++;
			}
			else {
				odd[oddIterator] = arr[i];
				oddIterator++;
			}			
		}
		System.out.println("The even elements are: ");
		for (int i = 0; i < evenIterator; i++) {
			System.out.print(even[i] + ", ");
		} 
		System.out.println();
		System.out.println("The odd elements are: ");
		for (int i = 0; i < oddIterator; i++) {
			System.out.print(odd[i] + ", ");
		}
		
	}
	
	public static String winLottery(int[] arr) {
		int[] winNumbers = new int[] {32, 4, 3, 14, 21, 27};
		int counter = 0;
		for (int i = 0; i < LOTTERY_NUMBERS; i++) {
			for (int j = 0; j < LOTTERY_NUMBERS; j++) {
				if (arr[i] == winNumbers[j]) {
					counter++;
				}
			}
		}

		String result = "";
		switch(counter) {
		case 6: result = "I won the lottery!";
		        break;
		case 5: result = "I won 5 of " + LOTTERY_NUMBERS;
		        break;
		case 4: result = "I won 4 of " + LOTTERY_NUMBERS;
                break;
        case 3: result = "I won 3 of " + LOTTERY_NUMBERS;
                break;
        default: result = "I didn't win. Next time, maybe.";
                break;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a decimal: ");
		byte decimal = sc.nextByte();
		decToBinary(decimal);
		sc.close();
		System.out.println();
		
		int[] arr = new int[NUMBER_OF_ELEMENTS];
		
		for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
			arr[i] = ((int)(Math.random()*(NUMBER_OF_ELEMENTS + 1)));
		}
		evenAndOddElements(arr);
		
		System.out.println();
		Random rand = new Random(System.currentTimeMillis());
		int[] numbers = new int[LOTTERY_NUMBERS];
		boolean areUnique = true;
		for (int i = 0; i < LOTTERY_NUMBERS; i++) {
			int currentElement = rand.nextInt(46);
			for (int j = i-1; j >= 0 && areUnique; j--) {
				if (numbers[i] == numbers[j]) {
					areUnique = false;
				}
			}
			if (areUnique && currentElement != 0) {
				numbers[i] = currentElement;
				areUnique = true;
			}
			else {
				i--;
			}
		}
		
		for (int i = 0; i < LOTTERY_NUMBERS; i++) {
			System.out.println(numbers[i]);
		}
		
		System.out.println(winLottery(numbers));
		
	}
}
