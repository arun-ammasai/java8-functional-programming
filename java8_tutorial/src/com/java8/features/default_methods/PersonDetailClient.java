package com.java8.features.default_methods;

import java.util.List;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

public class PersonDetailClient {

	static List<Person> listOfPersons = PersonRepository.getAllPersons();


	public static void main(String[] args) {
		PersonDetails pd = new PersonDetailImpl();
		System.out.println("Total Salary :" + pd.calculateTotalSalary(listOfPersons));
		System.out.println("Total Kids Count :" + pd.totalKids(listOfPersons));
		PersonDetails.personNames(listOfPersons).forEach(System.out::println);
		PersonDetailImpl.personNames(listOfPersons).forEach(System.out::println);
	}

}
