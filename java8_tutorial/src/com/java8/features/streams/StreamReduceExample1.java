package com.java8.features.streams;

import java.util.Optional;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

public class StreamReduceExample1 {

	public static void main(String[] args) {
		combineNames();
		Optional<Person> tallestPerson = getTallestPerson();
		System.out.println("Tallest Person is :"+tallestPerson.get());
	}

	private static void combineNames() {
		String names = PersonRepository.getAllPersons()
		.stream()
		.map(Person :: getName)
		.reduce("", (a,b) -> a.concat(b));
		System.out.println("Names are :"+names);
	}
	
	static Optional<Person> getTallestPerson() {
		return PersonRepository.getAllPersons()
		.stream()
		.reduce((x,y) -> x.getHeight() > y.getHeight() ? x : y);
	}

}
