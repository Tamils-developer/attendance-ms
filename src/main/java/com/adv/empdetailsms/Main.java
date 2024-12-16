package com.adv.empdetailsms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		// find number starts with 3
		List<Integer> insList = Arrays.asList(1, 2, 33, 44, 66, 22, 33, 333);
		List<String> list = insList.stream().map(w -> w + "").filter(w -> w.startsWith("3")).toList();
		System.out.println("Number starts with 3 - " + list);

		// find longest name
		List<String> strList = Arrays.asList("tamil", "kriuba", "mugeshmathi", "gabi", "tamilarasan", "gabiriel",
				"miller", "gabiriel", "augeshmathi");
		String max = strList.stream().max(Comparator.comparingInt(String::length)).get();
		System.out.println("Longest name - " + max);

		// names contains mil
		List<String> millList = strList.stream().filter(e -> e.contains("mil")).toList();
		System.out.println("Names containhs mil - " + millList);

		// find smallest name if tie return name
		Integer min = Collections.min(strList.parallelStream().map(e -> e.length()).toList());
		System.out.println("Min length - " + min);
		List<String> list3 = strList.stream().filter(e -> e.length() == min).toList();
		System.out.println("Min length name - " + list3);

		// count of name repetition
		Map<String, Long> collect = strList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Name repeatation - " + collect);

		// flat the list without duplicate and reverse sorted
		List<List<String>> nestedList = List.of(List.of("apple", "banana", "apple"),
				List.of("cherry", "date", "banana"), List.of("elderberry", "fig", "cherry"));
		List<String> newList = nestedList.stream().flatMap(e -> e.stream()).sorted(Comparator.reverseOrder()).distinct()
				.toList();
		System.out.println("Flat the list without duplicate and reverse sorted - " + newList);

		// group by department
		List<Employee> employees = List.of(new Employee("HR", 50000), new Employee("Engineering", 70000),
				new Employee("HR", 60000), new Employee("Engineering", 75000), new Employee("Finance", 50000));
		Map<String, Long> collect2 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("Group by dept - " + collect2);

		//
		List<Integer> numbers = List.of(4, 5, 6, 4, 7, 7, 5, 6, 4, 7, 7);
		Integer mostFrequent = numbers.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Count occurrences
				.entrySet().stream().sorted((e1, e2) -> {
					int freqCompare = e2.getValue().compareTo(e1.getValue()); // Sort by frequency (desc)
					if (freqCompare == 0) {
						return e1.getKey().compareTo(e2.getKey()); // If tie, sort by value (asc)
					}
					return freqCompare;
				}).map(Map.Entry::getKey) // Get the number
				.findFirst() // Retrieve the top result
				.orElseThrow();

		OptionalLong findFirst = numbers.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Count occurrences
				.entrySet().stream().mapToLong(e -> e.getValue()).sorted().max();
		IntSummaryStatistics summaryStatistics = insList.stream().mapToInt(e -> e).summaryStatistics();

		System.out.println("Max repeatation -" + findFirst.getAsLong());
		System.out.println("Summary of list - " + summaryStatistics);

		int frequency = Collections.frequency(numbers, 4);
		System.out.println("More frequency - " + frequency);

		List<Integer> salaries = List.of(70000, 85000, 70000, 95000, 85000, 110000);
		int n = 2;
		Integer integer = salaries.stream().sorted(Comparator.reverseOrder()).distinct().skip(n - 1).toList().get(0);

		System.out.println("Second highest salary - " + integer);

		// partition By
		List<Integer> numberss = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Map<Boolean, List<Integer>> collect3 = numberss.stream().collect(Collectors.partitioningBy(e -> e % 2 == 0));
		Map<Boolean, List<String>> collect4 = strList.stream()
				.collect(Collectors.partitioningBy(e -> e.contains("mil")));
		System.out.println("Partition by -" + collect4);

		List<String> strings = List.of("cat", "dog", "elephant", "antelope", "ant");
		String string = strings.stream().sorted().max(Comparator.comparingInt(String::length)).get();

		// Palindromes program
		List<String> words = List.of("radar", "level", "world", "hello", "madam");
		List<String> list4 = words.stream().filter(e -> e.toString().equals(new StringBuffer(e).reverse().toString()))
				.toList();
		System.out.println("Palindrome Program -" + list4);

		int mask = 0x000F;

		int value = 0x2222;

		System.out.println(mask & value);
		
		
//		Us us = new Us("A");
//		Us us2 = new Us("B");
//		us2.start();
//		us.start();
		Main main = new Main();
        main.met(e->{ return 0;});
	}
	
	
	public void met(Function<?,?> fn)  {
		System.out.println(fn);
	}

}

class Employee {
	String department;
	int salary;

	public Employee(String department, int salary) {
		super();
		this.department = department;
		this.salary = salary;
	}

	public synchronized String getDepartment() {
		return department;
	}

	public synchronized void setDepartment(String department) {
		this.department = department;
	}

	public synchronized int getSalary() {
		return salary;
	}

	public synchronized void setSalary(int salary) {
		this.salary = salary;
	}
}

class Us implements Runnable {
	private Thread i;

	private String tName;

	public Us(String tName) {
		this.tName = tName;
	}

	@Override
	public void run() {
		while (true)
			System.err.println(tName);
	}

	public void start() {

		if (i == null) {

			i = new Thread(this, tName);
			i.start();
		}
	}
}