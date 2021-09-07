package my.learning.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamClass {	

	public static void main(String[] args) {
		
		StreamClass obj = new StreamClass();
		List<Person> people = obj.getPeople();
		// Old fashioned (Imperative)
		/*
		List<Person> females = new ArrayList<Person>();
		for(Person p: people) {
			if(p.getGender().equals(Gender.FEMALE)){
				females.add(p);
			}
		}
		
		females.forEach(System.out::println); 
		*/
		// syntactic sugar for expression like females.forEach(p -> System.out:println(p); 
		
		// Declarative
		
		// filter
		List<Person> females = people.stream().filter(p -> p.getGender().equals(Gender.FEMALE))
		.collect(Collectors.toList());
		
		// females.forEach(System.out::println);
		
		// sort
		List<Person> sorted = people.stream().sorted(Comparator.comparing(Person::getGender).thenComparing(Person::getAge).reversed())
				.collect(Collectors.toList());
		
		// sorted.forEach(System.out::println);
		
		// allmatch
		boolean allMatch = people.stream().allMatch(p -> p.getAge() > 5);
		// System.out.println(allMatch);
		
		// anymatch
		boolean anyMatch = people.stream().anyMatch(p -> p.getAge() > 121);
		// System.out.println(anyMatch);
		
		// nonematch
		boolean noneMatch = people.stream().noneMatch(p -> p.getAge() > 121);
		// System.out.println(noneMatch);
		
		// max
		people.stream().max(Comparator.comparing(Person::getAge))
		.ifPresent(System.out::println);
		
		// min
		people.stream().min(Comparator.comparing(Person::getAge))
		.ifPresent(System.out::println);
		
		// Group
		Map<Gender, List<Person>> groupByGender = people.stream().collect(Collectors.groupingBy(Person::getGender));
		
		groupByGender.forEach((gender, people1) -> {
			System.out.println(gender);
			people1.forEach(System.out::println);
			System.out.println();
		});
		
	}
	
	private List<Person> getPeople(){
		// List.of (java 9) returns unmodifiable list. 
		return Arrays.asList(
				new Person("Ambadas", 38, Gender.MALE),
				new Person("Anitha", 34, Gender.FEMALE),
				new Person("Alok", 10, Gender.MALE),
				new Person("Akarsh", 6, Gender.MALE),
				new Person("ABC", 90, Gender.FEMALE),
				new Person("XYZ", 120, Gender.MALE)
				);
	}

}
