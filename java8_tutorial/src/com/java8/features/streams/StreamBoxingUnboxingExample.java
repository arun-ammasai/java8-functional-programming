package com.java8.features.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamBoxingUnboxingExample {
	
	static List<Integer> boxingMethod(){
		return IntStream.rangeClosed(1, 40) // primitive int
				.boxed() // converting to wrapper Integer
				.collect(Collectors.toList()); // collect as List
	}
	
	static int calcluateSum(List<Integer> list) {
		return list.stream()
				.mapToInt(Integer :: intValue) // Map do the converting part 
				.sum(); // performing sum operation
	}

	public static void main(String[] args) {
		boxingMethod().forEach(System.out::println);
		
		System.out.println("Sum is :"+calcluateSum(boxingMethod()));
	}

}
