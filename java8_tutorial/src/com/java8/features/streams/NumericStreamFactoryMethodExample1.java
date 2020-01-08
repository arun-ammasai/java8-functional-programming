package com.java8.features.streams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamFactoryMethodExample1 {

	public static void main(String[] args) {
		int sum = IntStream.rangeClosed(1, 50).sum();
		System.out.println("Total is :"+sum);
		
		OptionalInt max = IntStream.rangeClosed(1, 50).max();
		System.out.println("Max Value is :"+max.getAsInt());
		
		OptionalLong min = LongStream.rangeClosed(1, 50).min();
		System.out.println("Min Value is :"+min.getAsLong());
		
		OptionalDouble avg = LongStream.rangeClosed(1, 50).average();
		System.out.println("Average Value is :"+avg.getAsDouble());
	}

}
