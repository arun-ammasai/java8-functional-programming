package com.java8.features.default_methods;

import java.util.Comparator;
import java.util.List;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

public class DefaultCustomSortExample {
	
	static Comparator<Person> c1 = Comparator.comparing(Person :: getName);
	static Comparator<Person> c2 = Comparator.comparingDouble(Person :: getHeight);
	

	public static void main(String[] args) {
		List<Person> listOfPersons = PersonRepository.getAllPersons();
		//sortByName(listOfPersons);
		//sortByHeight(listOfPersons);
		//sortByHeightandName(listOfPersons);
		//sortByNameWithNull(listOfPersons);
		sortByNameWithNullLast(listOfPersons);
	}
	
	static void sortByName(List<Person> listOfPersons) {
		listOfPersons.sort(c1);
		listOfPersons.forEach(per -> System.out.println(per));
	}
	
	static void sortByHeight(List<Person> listOfPersons) {
		listOfPersons.sort(c2);
		listOfPersons.forEach(per -> System.out.println(per));
	}
	
	static void sortByHeightandName(List<Person> listOfPersons) {
		listOfPersons.sort(c1.thenComparing(c2));
		listOfPersons.forEach(per -> System.out.println(per));
	}
	
	static void sortByNameWithNull(List<Person> listOfPersons) {
		Comparator<Person> nullComp = Comparator.nullsFirst(c1);
		listOfPersons.sort(nullComp);
		listOfPersons.forEach(per -> System.out.println(per));
	}
	
	static void sortByNameWithNullLast(List<Person> listOfPersons) {
		Comparator<Person> nullComp = Comparator.nullsLast(c1);
		listOfPersons.sort(nullComp);
		listOfPersons.forEach(per -> System.out.println(per));
	}

}
