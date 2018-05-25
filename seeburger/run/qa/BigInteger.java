package com.seeburger.qa;

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
		public char compareAbsoluteValues(BigInteger bigInt2) {
		    char[] bigint1 = this.bigInt.toCharArray();
		    char[] bigint2 = bigInt2.bigInt.toCharArray();
		    
			if (bigint1.length < bigint2.length) 
				return '<';
			else if (bigint1.length > bigint2.length) 
				return '>';
			//if bigInt1 and bigInt2 have the same length
			else {
				//compare the bigInt elements with equal indexes
				for (int i = 0; i < bigint1.length; i++) {
					if (bigint1[i] < bigint2[i])
						return '<';
					else if (bigint1[i] > bigint2[i]) 
						return '>';
				}
			}
				return '=';
		}
			
		//compares two BigIntegers and returns '=', '<' or '>' 
		public char compare(BigInteger bigInt2) {
			// negative number is always < positive number
			if ((this.isNegative == true) && (bigInt2.isNegative == false)) {
				return '<';
			//positive number is > negative
			} else if ((this.isNegative == false) && (bigInt2.isNegative == true)) {
				return '>';
			}
			// positive numbers 
			else if ((this.isNegative == false) && (bigInt2.isNegative == false)){
				return this.compareAbsoluteValues(bigInt2);
			}
			//negative numbers, the number with bigger absolute value is <   
			return bigInt2.compareAbsoluteValues(this);
		}
		
		public BigInteger addByModule(BigInteger bigInt2) {
			char[] smaller = (this.compareAbsoluteValues(bigInt2) == '<' ? this.bigInt.toCharArray() : bigInt2.bigInt.toCharArray());
			char[] bigger = (this.compareAbsoluteValues(bigInt2) == '>' ? this.bigInt.toCharArray() : bigInt2.bigInt.toCharArray());
					
			return bigInt2;
		}
		
		@Override
		public String toString() { 
	          return "(" + this.bigInt + ")";
	       }
}

