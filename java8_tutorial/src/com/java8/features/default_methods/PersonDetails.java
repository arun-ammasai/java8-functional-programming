package com.java8.features.default_methods;

import java.util.List;
import java.util.stream.Collectors;

import com.java8.features.repo.Person;

public interface PersonDetails {
	double calculateTotalSalary(List<Person> personList);
	
	default int totalKids(List<Person> personList) {
		return personList.stream().map(Person::getKids).reduce(0, (x,y)-> x+y);
	}
	
	static List<String> personNames(List<Person> personList){
		return personList.stream().map(Person :: getName).collect(Collectors.toList());
	}
}
