package com.seeburger.qa;

import java.util.Arrays;

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
		private int compareAbsoluteValues(BigInteger bigInt2) {
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
		
		
		private BigInteger addByModule(BigInteger bigInt2) {
			char[] smaller = (this.compareAbsoluteValues(bigInt2) < 0 ? this.bigInt.toCharArray() : bigInt2.bigInt.toCharArray());
			char[] bigger = (this.compareAbsoluteValues(bigInt2) > 0 ? this.bigInt.toCharArray() : bigInt2.bigInt.toCharArray());
			
			//keeps the sum of BigIntegers
			StringBuilder additionResult = new StringBuilder();
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
						additionResult.append(digitSum%10);
						reminder = digitSum/10;
					}
					else {
						additionResult.append(digitSum);
					}
					//when we reach the initial digit of the smaller, push the rest of the bigger
					if(i == 0) {
						if(smaller.length != bigger.length) {
							j--;
							while(j >= 0) {
								additionResult.append(Character.getNumericValue(bigger[j])+reminder);
								j--;
								reminder = 0;
								}
						}
						else {
							if(reminder != 0){
								additionResult.append(reminder);
							}
						}
					}
			}
			BigInteger result = new BigInteger(additionResult.reverse().toString());
			return result;
		}
		
		private BigInteger subtractByModule(BigInteger bigInt2) {
			char[] smaller = (this.compareAbsoluteValues(bigInt2) < 0 ? this.bigInt.toCharArray() : bigInt2.bigInt.toCharArray());
			char[] bigger = (this.compareAbsoluteValues(bigInt2) > 0 ? this.bigInt.toCharArray() : bigInt2.bigInt.toCharArray());

			BigInteger subtractResult; 
			//|x| - |y|, y < x
			if (Arrays.equals(smaller,(bigInt2.bigInt.toCharArray()))) {
				String simpleSub = this.simpleSubtraction(bigInt2);
				subtractResult = new BigInteger(simpleSub); 
			}
			//|x| - |y|, x < y
			else if (Arrays.equals(bigger,(bigInt2.bigInt.toCharArray()))) {
				String simpleSub = bigInt2.simpleSubtraction(this);
				subtractResult = new BigInteger(simpleSub); 
				subtractResult.isNegative = true;
			}
			//|x| - |y|, x = y
			else { 
				String simpleSub = bigInt2.simpleSubtraction(this).substring(0, 1);
				subtractResult = new BigInteger(simpleSub); 
			}  
			return subtractResult;
		} 
		
		//helper method used for this case : |current| - |other| > 0
		private String simpleSubtraction(BigInteger bigInt2) {
			char[] smaller = (this.compareAbsoluteValues(bigInt2) < 0 ? this.bigInt.toCharArray() : bigInt2.bigInt.toCharArray());
			char[] bigger = (this.compareAbsoluteValues(bigInt2) > 0 ? this.bigInt.toCharArray() : bigInt2.bigInt.toCharArray());
			
			//keeps the subtract of BigIntegers
			StringBuilder subtractResult = new StringBuilder();
			Integer digitSubtract = 0;
			int reminder = 0;
			
			for(int i = smaller.length - 1, j = bigger.length - 1; i >= 0; i--, j--) {
				if (Character.getNumericValue(bigger[j])-reminder < Character.getNumericValue(smaller[i])) {
					digitSubtract = (Character.getNumericValue(bigger[j])+10 - Character.getNumericValue(smaller[i])-reminder);
					reminder = 1;
				}
				else {
					digitSubtract = (Character.getNumericValue(bigger[j]) - Character.getNumericValue(smaller[i]) - reminder);
					reminder = 0;
				}
			    subtractResult.append(digitSubtract);
			    if (i == 0) { 
			    	j--;
			    	while (j >= 0) {
			    		digitSubtract = Character.getNumericValue(bigger[j]) - reminder;
					    subtractResult.append(digitSubtract);
					    reminder = 0;
					    j--;
			    	}
			    }
			}
			return subtractResult.reverse().toString();
		} 
		
		public BigInteger add(BigInteger bigInt2) {
			BigInteger smaller = (this.compareAbsoluteValues(bigInt2) < 0 ? this : bigInt2);
			BigInteger bigger = (this.compareAbsoluteValues(bigInt2) > 0 ? this : bigInt2);
			
			BigInteger result;
			if (!this.isNegative && !bigInt2.isNegative) 
				result = this.addByModule(bigInt2);
			else if (this.isNegative && bigInt2.isNegative) {
				result = this.addByModule(bigInt2);
				result.isNegative = true;
			}
			else if (!bigger.isNegative && smaller.isNegative) {
				result = bigger.subtractByModule(smaller);
			}
			else {
				result = bigger.subtractByModule(smaller);
				result.isNegative = true;
			}
			return result;
		}
		
		public BigInteger subtract(BigInteger bigInt2) {
			BigInteger smaller = (this.compareAbsoluteValues(bigInt2) < 0 ? this : bigInt2);
			BigInteger bigger = (this.compareAbsoluteValues(bigInt2) > 0 ? this : bigInt2);
			
			BigInteger result;
			if (this.isNegative && !bigInt2.isNegative) {
				result = this.addByModule(bigInt2);
				result.isNegative = true;
			}
			else if (!this.isNegative && bigInt2.isNegative) {
				result = this.addByModule(bigInt2);
			}
			else if ((this.equals(bigger) && !this.isNegative) || (this.equals(smaller) && this.isNegative)) {
				result = this.subtractByModule(bigInt2);
			}
			else {
				result = this.subtractByModule(bigInt2);
				result.isNegative = true;
			}
			return result;
		}
		
		@Override
		public String toString() { 
			  if(this.isNegative)
				  return "-(" + this.bigInt + ")";
	          return "(" + this.bigInt + ")";
	       }
}
