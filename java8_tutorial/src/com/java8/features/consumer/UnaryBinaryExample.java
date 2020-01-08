package com.java8.features.consumer;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryBinaryExample {
	
	static UnaryOperator<String> uo1 = name -> name.toUpperCase();
	static UnaryOperator<Integer> uo2 = a -> a+10;
	static Comparator<Integer> comp = (a,b) -> a.compareTo(b);
	public static void main(String[] args) {
		//System.out.println("Result 1:"+uo1.apply("java8"));
		//System.out.println("Result 2:"+uo2.apply(20));
		
		BinaryOperator<Integer> bo1 = BinaryOperator
				.maxBy((a, b) -> (a > b) ? 1 : (a == b) ? 0 : -1);
		System.out.println("Binary Operator MaxBy Result 1:"+bo1.apply(102, 15));
		
		BinaryOperator<Integer> bo2 = BinaryOperator.maxBy(comp);
		System.out.println("Binary Operator MaxBy Result 2:" + bo2.apply(102, 15));
		
		BinaryOperator<Integer> bo3 = BinaryOperator.minBy(comp);
		System.out.println("Binary Operator MinBy Result 3:" + bo3.apply(102, 15));
	}

}
