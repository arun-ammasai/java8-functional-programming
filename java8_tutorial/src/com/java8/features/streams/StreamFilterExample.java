package com.java8.features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

public class StreamFilterExample {
	
	static Predicate<Person> p1 = per -> per.getHeight() >= 140;
	static Predicate<Person> p2 = per -> per.getGender().equals("Male");

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Sam","Anderson","Peter","Nancy");
		
		Stream<String> allNames = names.stream();
		
		Stream<String> updatesList = allNames.filter(s -> s.length() > 3);
		
		updatesList.forEach(System.out :: println);
		
		names.stream().filter(s-> s.length()>3).collect(Collectors.toList()).forEach(System.out :: println);
		
		PersonRepository.getAllPersons()
		.stream()
		.filter(p1.and(p2))
		//.filter(p2)
		.collect(Collectors.toList()).forEach(System.out :: println);
		
		/*List<Person> l1 = PersonRepository.getAllPersons()
				.stream()
				.filter(per -> per.getHeight() >= 140)
				.collect(Collectors.toList());
		l1.forEach(System.out :: println);*/
		
		
	}

}
