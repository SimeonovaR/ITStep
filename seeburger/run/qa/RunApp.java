package com.seeburger.run;

import com.seeburger.qa.BigInteger;

public class RunApp {
	
	public static void main(String[] args) {
        BigInteger b1= new BigInteger("645353");
        BigInteger b2= new BigInteger("-210");
        
        BigInteger addResult = b1.add(b2);
        System.out.println(b1 + " + " + b2 + " = " + addResult);

	}
	
}
