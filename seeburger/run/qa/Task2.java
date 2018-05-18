package com.seeburger.qa;

import java.util.Stack;

public class Task2 {
	static final int STACK_PEEK = 4;

	public static void numbersLine(Stack<Integer> st, int peekElement) {
		System.out.print(peekElement + " ");

		if (st.size() == STACK_PEEK) {
			while(!st.empty()) {
				System.out.print(st.pop() + " ");
			}
			return;
	    }		
	    numbersLine(st, st.push(peekElement*10));
	}

	public static void main(String[] args) {
		Stack<Integer> recStack = new Stack<>();
		int initialElement = 10;
		recStack.push(initialElement);
		numbersLine(recStack, initialElement);
	}
}
