package com.seeburger.qa;

import java.util.Stack;

public class BigInteger {
	private String bigInt;
	
	public BigInteger(String bigInt) {
		this.bigInt = bigInt; 
	}
		
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
		
		//the stack pushes the elements of BigInteger as Integers
		private Stack<Integer> listOfDigitSum(char[] bigInteger) {	
			char[] biggerElement = returnBigger(this.bigInt.toCharArray(), bigInteger);
			char[] smallerElement = returnSmaller(this.bigInt.toCharArray(), bigInteger);
			
			Integer remainder = 0;
			Stack<Integer> bigIntegerSt = new Stack<>();
			
			if (isNegative(smallerElement) && isNegative(biggerElement)) {
				for (int i = smallerElement.length-1, j = biggerElement.length-1; i > 0; i--, j--) {
					//push elements with the same indexes and cope with the remainder, so
					//if the sum of two digits is >= 10, it pushes the peek%10 and returns as reminder the peek/10 
					bigIntegerSt.push(Character.getNumericValue(smallerElement[i]) +
							Character.getNumericValue(biggerElement[j]) + remainder);
					if (i == 1) {
						for (int k = j - 1; k >= 0; k--) {
							bigIntegerSt.push(Character.getNumericValue(biggerElement[k]));
						}					
					}
					if(bigIntegerSt.peek() >= 10) {
						remainder = manageRemainder(bigIntegerSt);
					}
				}
			}
			if (!isNegative(smallerElement)) {
				for (int i = smallerElement.length-1, j = biggerElement.length-1; i >= 0; i--, j--) {
					bigIntegerSt.push(Character.getNumericValue(smallerElement[i]) + 
							Character.getNumericValue(biggerElement[j] + remainder));
					if (i == 0) {
						for (int k = j - 1; k >= 0; k--) {
							bigIntegerSt.push(Character.getNumericValue(biggerElement[k]));
						}					
					}
					if(bigIntegerSt.peek() >= 10) {
						remainder = manageRemainder(bigIntegerSt);
					}
				}
			}
			
			if(isNegative(smallerElement)) {
				for (int i = smallerElement.length-1, j = biggerElement.length-1; i > 0; i--, j--) {
					bigIntegerSt.push(Character.getNumericValue(smallerElement[i]) + 
							Character.getNumericValue(biggerElement[j]) + remainder);
					if (i == 1) {
						for (int k = j - 1; k >= 0; k--) {
							bigIntegerSt.push(Character.getNumericValue(biggerElement[k]));
						}					
						bigIntegerSt.push(-1);
					}
					if(bigIntegerSt.peek() >= 10) {
						remainder = manageRemainder(bigIntegerSt);
					}
				}

			}
			return bigIntegerSt;
		}
		
	      
		public String getBigInt() {
			return bigInt;
		}
		
		public static char[] convertBigIntegertoCharArray(BigInteger bigInt) {
			String bigIntStr = bigInt.getBigInt();
			return bigIntStr.toCharArray();
		}
		
		public char[] returnBigger(char[] firstNum, char[] secondNum) {

			return (compareAccordingToLengths(firstNum, secondNum) == '>' ? firstNum : secondNum);
		}
		
		public char[] returnSmaller(char[] firstNum, char[] secondNum) {

			return (compareAccordingToLengths(firstNum, secondNum) == '<' ? firstNum : secondNum);
		}
	      
		public BigInteger add(BigInteger bigInteger) {	
			Stack<Integer> bigIntegerSt = this.listOfDigitSum(convertBigIntegertoCharArray(bigInteger));	
			//if the stack peek is -1, then the BigInteger is considered as negative number
			//we pop the peek and multiply the new peek by -1
			if (bigIntegerSt.peek() == -1) {
				bigIntegerSt.pop();
				Integer peek = bigIntegerSt.peek();
				peek *= -1;
				bigIntegerSt.pop();
				bigIntegerSt.push(peek);
			}
			StringBuilder sumOfBigInts = new StringBuilder();
			while (!bigIntegerSt.isEmpty()) {
				//System.out.print(bigIntegerSt.pop());
				sumOfBigInts.append(bigIntegerSt.pop());
			}
			return new BigInteger(sumOfBigInts.toString());
		}
		

		public String toString() { 
	          return "(" + this.bigInt + ")";
	       }


}
