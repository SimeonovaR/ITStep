package com.seeburger.qa;

import java.util.Stack;

public class Task3 {
	//returns true if the number is negative
	public static boolean isNegative(char[] bigInt) {
		if (bigInt[0] == '-') {
			return true;
		}
		return false;
	}
	
	//returns the size of the BigInteger element except the sign
	public static int getBigIntSize(char[] bigInt) {
		if (isNegative(bigInt))
			return (bigInt.length-1);
		return bigInt.length;
	}
	
	//compare the number of elements in the BigInteger 
	public static char compareAccordingToLengths(char[] bigInt1, char[] bigInt2) {
		if (getBigIntSize(bigInt1) < getBigIntSize(bigInt2)) 
			return '<';
		else if (getBigIntSize(bigInt1) > getBigIntSize(bigInt2)) 
			return '>';
		//if bigInt1 and bigInt2 have the same length
		else {
			//compare the bigInt elements with equal indexes
			for (int i = 0; i < bigInt1.length; i++) {
				if (bigInt1[i] < bigInt2[i])
					return '<';
				else if (bigInt1[i] > bigInt2[i]) 
					return '>';
			}
		}
			return '=';
	}
		
	//compares two BigIntegers and returns '=', '<' or '>' 
	public static char compare(char[] bigInt1, char[] bigInt2) {
		// negative number is always < positive number
		if (isNegative(bigInt1) && !isNegative(bigInt2)) {
			return '<';
		//positive number is > negative
		} else if (!isNegative(bigInt1) && isNegative(bigInt2)) {
			return '>';
		}
		// positive numbers 
		else if (!isNegative(bigInt1) && !isNegative(bigInt2)){
			return compareAccordingToLengths(bigInt1, bigInt2);
		}
		//negative numbers, the number with bigger absolute value is <   
		return compareAccordingToLengths(bigInt2, bigInt1);
	}
	
	//handle with remainder in bigInteger list 
	public static Integer manageRemainder(Stack<Integer> st) {
		Integer peek = st.peek();
		Integer el = peek%10;
		st.pop();
		st.push(el);
		
		return (peek/10);
	}
	
	public static Stack<Integer> listOfDigitSum(char[] bigInt1, char[] bigInt2) {
		char[] biggerElement;
		char[] smallerElement;

		if (compareAccordingToLengths(bigInt1, bigInt2) == '>') {
			biggerElement = bigInt1;
			smallerElement = bigInt2;
		}
		else {
			biggerElement = bigInt2;
			smallerElement = bigInt1;
		}
		Stack<Integer> bigInteger = new Stack<>();	
		Integer remainder = 0;
		if (isNegative(smallerElement) && isNegative(biggerElement)) {
			for (int i = smallerElement.length-1, j = biggerElement.length-1; i > 0; i--, j--) {
				bigInteger.push(Character.getNumericValue(smallerElement[i]) +
						Character.getNumericValue(biggerElement[j]) + remainder);
				if (i == 1) {
					for (int k = j - 1; k >= 0; k--) {
						bigInteger.push(Character.getNumericValue(biggerElement[k]));
					}					
				}
				if(bigInteger.peek() >= 10) {
					remainder = manageRemainder(bigInteger);
				}
			}
		}
		if (!isNegative(smallerElement)) {
			for (int i = smallerElement.length-1, j = biggerElement.length-1; i >= 0; i--, j--) {
				bigInteger.push(Character.getNumericValue(smallerElement[i]) + 
						Character.getNumericValue(biggerElement[j] + remainder));
				if (i == 0) {
					for (int k = j - 1; k >= 0; k--) {
						bigInteger.push(Character.getNumericValue(biggerElement[k]));
					}					
				}
				if(bigInteger.peek() >= 10) {
					remainder = manageRemainder(bigInteger);
				}
			}
		}
		
		if(isNegative(smallerElement)) {
			for (int i = smallerElement.length-1, j = biggerElement.length-1; i > 0; i--, j--) {
				bigInteger.push(Character.getNumericValue(smallerElement[i]) + 
						Character.getNumericValue(biggerElement[j]) + remainder);
				if (i == 1) {
					for (int k = j - 1; k >= 0; k--) {
						bigInteger.push(Character.getNumericValue(biggerElement[k]));
					}					
					bigInteger.push(-1);
				}
				if(bigInteger.peek() >= 10) {
					remainder = manageRemainder(bigInteger);
				}
			}

		}
		return bigInteger;
	}
	
	public static void sumBigIntegers(Stack<Integer> st) {
		if (st.peek() == -1) {
			st.pop();
			Integer peek = st.peek();
			peek *= -1;
			st.pop();
			st.push(peek);
		}
		while (!st.isEmpty()) {
			System.out.print(st.pop());
		}
	}
	
	
	
	public static void main(String[] args) {
		String bigInt1= new String("-27");
        String bigInt2= new String("365");
        
        char[] bigIntArr1 = bigInt1.toCharArray();
        char[] bigIntArr2 = bigInt2.toCharArray();
        
        System.out.println(bigInt1 + " " + compare(bigIntArr1, bigIntArr2) + " " + bigInt2);
        Stack<Integer> listOfElements = listOfDigitSum(bigIntArr1, bigIntArr2);
        sumBigIntegers(listOfElements);
	}
}