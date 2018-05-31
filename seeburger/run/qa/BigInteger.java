package com.seeburger.qa;

import java.util.Stack;

public class BigInteger {
	private String bigInt;
	private boolean isNegative;
	
	public BigInteger(String bigInt) {
		if (bigInt.charAt(0) == '-') {
			isNegative = true;
			this.bigInt = bigInt.substring(1);
		}
		else {
			this.bigInt = bigInt;
		}
	}
	
		//compare lengths of digits in the BigInteger by absolute values  
		public int compareAbsoluteValues(BigInteger bigInt2) {
		    char[] bigint1 = this.bigInt.toCharArray();
		    char[] bigint2 = bigInt2.bigInt.toCharArray();
		    
			if (bigint1.length < bigint2.length) 
				return -1;
			else if (bigint1.length > bigint2.length) 
				return 1;
			//if bigInt1 and bigInt2 have the same length
			else {
				//compare the bigInt elements with equal indexes
				for (int i = 0; i < bigint1.length; i++) {
					if (bigint1[i] < bigint2[i])
						return -1;
					else if (bigint1[i] > bigint2[i]) 
						return 1;
				}
			}
				return 0;
		}
			
		//compares two BigIntegers and returns a negative integer, zero, or a positive integer 
		//as the first argument is less than, equal to, or greater than the second 
		public int compare(BigInteger bigInt2) {
			// negative number is always < positive number
			if ((this.isNegative == true) && (bigInt2.isNegative == false)) {
				return -1;
			//positive number is > negative
			} else if ((this.isNegative == false) && (bigInt2.isNegative == true)) {
				return 1;
			}
			// positive numbers 
			else if ((this.isNegative == false) && (bigInt2.isNegative == false)){
				return this.compareAbsoluteValues(bigInt2);
			}
			//negative numbers, the number with bigger absolute value is <   
			return bigInt2.compareAbsoluteValues(this);
		}
		
		
		public Stack<Integer> addByModule(BigInteger bigInt2) {
			char[] smaller = (this.compareAbsoluteValues(bigInt2) < 0 ? this.bigInt.toCharArray() : bigInt2.bigInt.toCharArray());
			char[] bigger = (this.compareAbsoluteValues(bigInt2) > 0 ? this.bigInt.toCharArray() : bigInt2.bigInt.toCharArray());
			
			//keeps the sum of BigIntegers
			Stack<Integer> additionResult = new Stack<>();
			Integer digitSum;
			int reminder = 0;
			
			//iterate digits in the BigIntegers conversely, add them and push the result in the stack 
			for(int i = smaller.length - 1, j = bigger.length - 1; i >= 0; i--, j--) {
				digitSum = Character.getNumericValue(smaller[i]) + Character.getNumericValue(bigger[j]);
				if (reminder != 0) {
					digitSum += reminder;
					reminder = 0;
				}
					if (digitSum >= 10) {
						additionResult.push(digitSum%10);
						reminder = digitSum/10;
					}
					else {
						additionResult.push(digitSum);
					}
					//when we reach the initial digit of the smaller, push the rest of the bigger
					if(i == 0) {
						if(smaller.length != bigger.length) {
							j--;
							while(j >= 0) {
								additionResult.push(Character.getNumericValue(bigger[j])+reminder);
								j--;
								reminder = 0;
								}
						}
						else {
							if(reminder != 0){
								additionResult.push(reminder);
							}
						}
					}
			}
			return additionResult;
		}
		
				public Stack<Integer> subtractByModule(BigInteger bigInt2) {
			char[] smaller = (this.compareAbsoluteValues(bigInt2) < 0 ? this.bigInt.toCharArray() : bigInt2.bigInt.toCharArray());
			char[] bigger = (this.compareAbsoluteValues(bigInt2) > 0 ? this.bigInt.toCharArray() : bigInt2.bigInt.toCharArray());
			
			//keeps the subtract of BigIntegers
			Stack<Integer> subtractResult = new Stack<>();
			Integer digitSubtract = 0;
			int reminder = 0;
			
			if (smaller.equals(bigInt2.bigInt.toCharArray())) {
				for(int i = smaller.length - 1, j = bigger.length - 1; i >= 0; i--, j--) {
					if (Character.getNumericValue(bigger[j]) < Character.getNumericValue(smaller[i])) {
						digitSubtract = (Character.getNumericValue(bigger[j])+10 - Character.getNumericValue(smaller[i])-reminder);
						reminder = 1;
					}
					else {
						digitSubtract = (Character.getNumericValue(bigger[j]) - Character.getNumericValue(smaller[i]) - reminder);
					}
				    subtractResult.push(digitSubtract);
				    if (i == 0) { 
				    	j--;
				    	while (j >= 0) {
						    subtractResult.push(bigger[j] - reminder);
						    reminder = 0;
						    j--;
				    	}
				    }
				}
			}
			else //if(smaller.equals(this.bigInt.toCharArray())) 
			{
				subtractResult = simpleSubtraction(bigInt2.bigInt.toCharArray());
				subtractResult.push(-1);
			}
			/*else { 
				digitSubtract = 0;
				subtractResult.push(digitSubtract);
			}  */
			return subtractResult;
		}
		
		private Stack<Integer> simpleSubtraction(char[] charArray) {
			// TODO Auto-generated method stub
			return 0;
		}
	
		@Override
		public String toString() { 
	          return "(" + this.bigInt + ")";
	       }
}
