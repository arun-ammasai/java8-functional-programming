package com.java8.features.optional;

import java.util.Optional;

public class OptionalPresentExample {

	public static void main(String[] args) {
		Optional<String> ofNullable = Optional.ofNullable("JAVA8");
		System.out.println(ofNullable.isPresent() ? ofNullable.get() : Optional.empty());
		ofNullable.ifPresent(s-> System.out.println(s));
	}

}
