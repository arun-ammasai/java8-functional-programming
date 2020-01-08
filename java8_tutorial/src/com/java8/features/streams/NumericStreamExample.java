package com.java8.features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

public class NumericStreamExample {

	static BinaryOperator<Integer> bo = (x, y) -> x + y;

	static int calculateSum(List<Integer> l1) {
		return l1.stream().reduce(0, bo);
	}
	
	static int calculateSumWithStream(IntStream intStream) {
		return intStream.sum();
	}

	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(1,2,3,4,5,6);
		System.out.println("Total is :"+calculateSum(l1));
		IntStream intStream = IntStream.rangeClosed(1, 6);
		System.out.println("Total Using Stream :"+calculateSumWithStream(intStream));
	}

}
