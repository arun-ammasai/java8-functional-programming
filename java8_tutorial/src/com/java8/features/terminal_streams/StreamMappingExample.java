package com.java8.features.terminal_streams;

import static java.util.stream.Collectors.mapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

public class StreamMappingExample {
	
	static List<String> mappingName(){
		List<String> names = PersonRepository.getAllPersons()
		.stream()
		.map(Person :: getName).
		collect(Collectors.toList());
		
		List<String> names1 = PersonRepository.getAllPersons()
		.stream().collect(mapping(Person::getName,Collectors.toList()));
		return names1;
	}
	
	static Set<String> mappingName1(){
		List<String> names = PersonRepository.getAllPersons()
		.stream()
		.map(Person :: getName).
		collect(Collectors.toList());
		
		Set<String> names1 = PersonRepository.getAllPersons()
		.stream().collect(mapping(Person::getName,Collectors.toSet()));
		return names1;
	}
	
	static long countTallPersons() {
		return PersonRepository.getAllPersons()
				.stream()
				.filter(per -> per.getHeight() >= 140)
				.collect(Collectors.counting());
	}
	

	public static void main(String[] args) {
		//mappingName().forEach(System.out::println);
		//mappingName1().forEach(System.out::println);
		System.out.println("Total person count :"+countTallPersons());
	}

}
