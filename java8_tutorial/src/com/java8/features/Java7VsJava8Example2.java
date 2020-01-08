package com.java8.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java7VsJava8Example2 {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Sam","Peter","Billings","Sam");
		
		//Before
		List<String> uniqueList = new ArrayList<>();
		for(String name : names) {
			if(!uniqueList.contains(name)) {
				uniqueList.add(name);
			}
		}
		System.out.println("Unique List 1 :"+uniqueList);
		
		//After
		List<String> uniqueValues1 = names.stream()
				.distinct()
				.collect(Collectors.toList());
		System.out.println("Unique List 2 :"+uniqueValues1);
		
		
	}

}
