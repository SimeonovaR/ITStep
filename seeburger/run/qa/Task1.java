package com.seeburger.qa;

import java.util.Stack;

public class Task1 {
	public static Stack<Integer> numberToDigits(int number) {
		Stack<Integer> digits = new Stack<>();
		while(number > 0) {
			digits.push(number%10);
			number /= 10;
		}
		return digits;
	}
	
	public static void printStackDigits(Stack<Integer> digits) {
		while (!digits.isEmpty()) {
			System.out.print(digits.pop() + " ");
		}
	}
	
	
	public static void main(String[] args) {
		Stack<Integer> digits = numberToDigits(9821);
		printStackDigits(digits);
	}
}
