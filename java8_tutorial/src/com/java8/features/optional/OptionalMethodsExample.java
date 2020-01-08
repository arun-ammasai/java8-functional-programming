package com.java8.features.optional;

import java.util.Optional;

public class OptionalMethodsExample {

	public static void main(String[] args) {
		Optional<String> ofNullable = Optional.ofNullable("JAVA8");
		System.out.println(ofNullable.isPresent() ? ofNullable.get() : Optional.empty());
		
		Optional<String> of = Optional.of("Hello");
		System.out.println(of.isPresent() ? of.get() : Optional.empty());
		
		System.out.println(Optional.empty());
		
		
	}

}
