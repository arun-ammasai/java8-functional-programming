package com.java8.features.streams;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamFactoryMethodExample {

	public static void main(String[] args) {
		IntStream intStream1 = IntStream.rangeClosed(1, 6);
		IntStream intStream2 = IntStream.range(1, 6);
		//intStream1.forEach(System.out :: println);
		System.out.println("------------------");
		//intStream2.forEach(System.out :: println);
		
		LongStream.rangeClosed(1, 50).forEach(System.out :: println);
		LongStream.rangeClosed(1, 50).asDoubleStream().forEach(System.out :: println);
		DoubleStream ds =LongStream.rangeClosed(1, 50).asDoubleStream();
		
	}

}
