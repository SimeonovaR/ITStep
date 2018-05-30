package com.seeburger.qa;

import java.util.Stack;

public class RunBigInteger {

	public static void main(String[] args) {
		BigInteger bigInt1 = new BigInteger("69");
		BigInteger bigInt2 = new BigInteger("98537");
		
		Stack add = bigInt1.addByModule(bigInt2);
		while (!add.isEmpty()) {
			System.out.println(add.pop());
		}
	}
}
