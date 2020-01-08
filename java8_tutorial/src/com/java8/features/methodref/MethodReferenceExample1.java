package com.java8.features.methodref;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

public class MethodReferenceExample1 {
	
	static Function<String, String> f1 = name -> name.toUpperCase(); 
	static Function<String, String> f2 = String :: toUpperCase;
	
	static Predicate<Person> p1 = per -> per.getHeight() >=140;
	static Predicate<Person> p2 = MethodReferenceExample1 :: heightCheck;
	static BiPredicate<Person,Integer> p3 = MethodReferenceExample1 :: heightCheckWithParam;
	static Function<String,String> f3 = MethodReferenceExample1 :: sayMyName ;

	public static void main(String[] args) {
		//System.out.println("Lambda Expression Result :"+f1.apply("java8"));
		//System.out.println("Method Reference Result :"+f2.apply("java8"));
		System.out.println("Predicate 1 Result :"+p1.test(PersonRepository.getPerson()));
		System.out.println("Predicate 2 Result :"+p2.test(PersonRepository.getPerson()));
		System.out.println("Predicate 3 Result :"+p3.test(PersonRepository.getPerson(),145));
		System.out.println("Function Test :"+f3.apply("java8"));
	}
	
	static boolean heightCheck(Person per) {
		return per.getHeight() >= 140;
	}
	
	static boolean heightCheckWithParam(Person per, Integer height) {
		return per.getHeight() >= height;
	}
	
	static String sayMyName(String name){
		return "Hello Mr."+name;
	}

}
