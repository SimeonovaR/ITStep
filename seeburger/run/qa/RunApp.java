package com.seeburger.qa;

public class RunBigInteger {

	public static void main(String[] args) {
        BigInteger b1= new BigInteger("3597");
        BigInteger b2= new BigInteger("2100");

        BigInteger addResult = b1.add(b2);
        System.out.println(b1.toString() + " + " + b2.toString() + " = " + addResult.toString());

        BigInteger substractRes = b1.subtract(b2);
        System.out.println(b1.toString() + " - " + b2.toString() + " = " + substractRes.toString());

	}
}
