package com.java8.features.streams;

import java.util.Arrays;
import java.util.List;

public class StreamReduceExample {

	public static void main(String[] args) {
		List<Integer> listofIntegers = Arrays.asList(1,2,3,4,5);
		int sum = listofIntegers.stream().mapToInt(i -> i).sum();
		System.out.println("Sum Result :"+sum);
		System.out.println(listofIntegers.stream().mapToInt(i -> i).count());
		
		System.out.println("Result of Multiplication :"+listofIntegers.stream().reduce(1, (a,b) -> a*b));
		// 1*1 = 1
		// 1*2 = 2
		// 2*3 = 6
		// 6*4 = 24
		// 24*5 = 120
		
		System.out.println("Result of Addition :"+listofIntegers.stream().reduce(0, (a,b) -> a+b));		
		
		
	}

}
