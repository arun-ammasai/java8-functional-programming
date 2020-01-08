package com.java8.features.terminal_streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

import java.util.HashMap;
import java.util.stream.Stream;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

public class StreamGroupingExample {
	
	static void groupByGender() {
		Map<String,List<Person>> groupedData = PersonRepository.getAllPersons().stream().collect(Collectors.groupingBy(Person :: getGender));
		//groupedData.entrySet().forEach(per -> System.out.println("Key :"+per.getKey()+"/ Value :"+per.getValue()));
		Stream.of(groupedData).forEach(System.out::println);
	}
	
	static void groupByHeight() {
		Map<String,List<Person>> groupedData = PersonRepository.getAllPersons().stream()
				.collect(Collectors.groupingBy(per -> per.getHeight() >= 140 ? "Tallest":"Shortest"));
		Stream.of(groupedData).forEach(System.out::println);
	}
	
	static void twoLevelGrouping() {
		Map<String,Map<String,List<Person>>> groupedData= PersonRepository.getAllPersons()
		.stream()
		.collect(Collectors.groupingBy(Person :: getGender, groupingBy(per -> per.getHeight() >= 140 ? "Tallest":"Shortest")));
		Stream.of(groupedData).forEach(System.out::println);
	}
	static void twoLevelGroupingCount() {
		Map<String , Integer> groupedData = PersonRepository.getAllPersons()
		.stream()
		.collect(Collectors.groupingBy(Person :: getName, summingInt(Person :: getKids)));
		Stream.of(groupedData).forEach(System.out::println);
	}
	
	static void threeLevelGrouping() {
		Map<String,List<Person>> groupedData = PersonRepository.getAllPersons()
				.stream()
				.collect(Collectors.groupingBy(Person::getName, HashMap :: new , Collectors.toList()));
		Stream.of(groupedData).forEach(System.out::println);
	}

	public static void main(String[] args) {
		//groupByGender();
		//groupByHeight();
		//twoLevelGrouping();
		//twoLevelGroupingCount();
		threeLevelGrouping();
	}

}
