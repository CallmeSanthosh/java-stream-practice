package com.streams.challenges;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class EasyStreamChallenges {

	// Dataset 1: Integers
	List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 3, 7, 4, 6, 10, 2, 5, 8);

	// Dataset 2: Strings (names)
	List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Alex", "Brian", "Catherine",
			"Daniel", "Emma");

	// Dataset 3: Strings (fruits with duplicates)
	List<String> fruits = Arrays.asList("apple", "banana", "cherry", "apple", "date", "banana", "elderberry", "fig",
			"grape", "apple");

	// Dataset 4: Mixed strings
	List<String> words = Arrays.asList("java", "stream", "lambda", "function", "method", "class", "object", "interface",
			"abstract", "final");

	// Dataset 5: Decimal numbers
	List<Double> prices = Arrays.asList(19.99, 45.50, 12.75, 89.00, 33.25, 67.80, 5.49, 150.00, 22.10, 8.99);

	protected void runNumberChallenges() {
		System.out.println("From the numbers list, print all numbers.");
		numbers.forEach(n -> System.out.print(n + " "));
		System.out.println();

		System.out.println("From the numbers list, get all even numbers into a new list.");
		List<Integer> numberList = numbers.stream().filter(n -> n % 2 == 0).toList();
		numberList.forEach(n -> System.out.print(n + " "));
		System.out.println();

		System.out.println("From the numbers list, get all numbers greater than 5 into a new list.");
		List<Integer> greaterThanFiveList = numbers.stream().filter(n -> n > 5).toList();
		greaterThanFiveList.forEach(n -> System.out.print(n + " "));
		System.out.println();

		System.out.println("From the numbers list, get the squares of all numbers into a new list.");
		List<Integer> squaresList = numbers.stream().map(n -> n * n).toList();
		squaresList.forEach(n -> System.out.print(n + " "));
		System.out.println();

		System.out.println("From the numbers list, count how many numbers are odd.");
		long oddCount = numbers.stream().filter(n -> n % 2 != 0).count();
		System.out.print(oddCount);

		System.out.println("From the numbers list, remove duplicates and return the result as a list.");
		List<Integer> uniqueList = numbers.stream().distinct().toList();
		Set<Integer> uniqueList1 = numbers.stream().collect(Collectors.toSet());

		uniqueList.forEach(n -> System.out.print(n + " "));
		System.out.println();
		uniqueList1.forEach(n -> System.out.print(n + " "));
		System.out.println();

		System.out.println("From the numbers list, sort them in ascending order.");
		List<Integer> sort = numbers.stream().sorted().toList();
		sort.forEach(n -> System.out.print(n + " "));
		System.out.println();

		System.out.println("From the numbers list, sort them in descending order.");
		List<Integer> sortReverse = numbers.stream().sorted(Comparator.reverseOrder()).toList();
		sortReverse.forEach(n -> System.out.print(n + " "));
		System.out.println();

		System.out.println("From the numbers list, get the first 5 elements.");
		List<Integer> firstFive = numbers.stream().limit(5).toList();
		firstFive.forEach(n -> System.out.print(n + " "));
		System.out.println();

		System.out.println("From the numbers list, skip the first 3 elements and get the rest.");
		List<Integer> skipFirstThree = numbers.stream().skip(3).toList();
		skipFirstThree.forEach(n -> System.out.print(n + " "));
		System.out.println();
	}

	protected void runNamesChallenges() {
		System.out.println("From the names list, Convert all names to uppercase.");
		List<String> upperCase = names.stream().map(String::toUpperCase).collect(Collectors.toList());
		upperCase.forEach(System.out::println);
		System.out.println();

		System.out.println("From the names list, Get all names that start with the letter \"A\".");
		List<String> startWithA = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
		startWithA.forEach(System.out::println);
		System.out.println();

		System.out.println("From the names list, Get all names that have more than 4 characters.");
		List<String> nameLengthMoreThanFour = names.stream().filter(name -> name.length() > 4)
				.collect(Collectors.toList());
		nameLengthMoreThanFour.forEach(System.out::println);
		System.out.println();

		System.out.println("From the names list, Get the length of each name as a list of integers.");
		List<Integer> nameLength = names.stream().map(String::length).collect(Collectors.toList());
		nameLength.forEach(System.out::println);
		System.out.println();

		System.out.println("From the names list, Join all names into a single comma-separated string.");
		String namesAsString = names.stream().collect(Collectors.joining(", "));
		System.out.println(namesAsString);
		System.out.println();

		System.out.println("From the names list, check if any name starts with \"Z\".");
		boolean isNameStartsWithZ = names.stream().anyMatch(name -> name.startsWith("Z"));
		System.out.println(isNameStartsWithZ);
		System.out.println();

		System.out.println("From the names list, check if all names have length greater than 2.");
		boolean isNameLengthGreaterThan2 = names.stream().allMatch(name -> name.length() > 2);
		System.out.println(isNameLengthGreaterThan2);
		System.out.println();

		System.out.println("From the names list, find the first name that starts with \"C\".");
		Optional<String> firstNameStartWithC = names.stream().filter(name -> name.startsWith("C")).findFirst();
		System.out.println(firstNameStartWithC.orElse("Not found"));
		System.out.println();
	}

	protected void runFruitsChallenges() {
		System.out.println("From the fruits list, get only the unique fruit names.");
		List<String> uniqueFruitNames = fruits.stream().distinct().collect(Collectors.toList());
		uniqueFruitNames.forEach(System.out::println);
		System.out.println();

		System.out.println("From the fruits list, count how many unique fruits exist.");
		long uniqueFruitNamesCount = fruits.stream().distinct().count();
		System.out.println(uniqueFruitNamesCount);
		System.out.println();

		System.out.println("From the fruits list, sort them alphabetically and convert to uppercase.");
		List<String> sortAndUpperCase = fruits.stream().map(String::toUpperCase).sorted().toList();
		sortAndUpperCase.forEach(System.out::println);
		System.out.println();

		System.out.println("From the fruits list, get fruits that contain the letter \"a\".");
		List<String> fruitWithA = fruits.stream().filter(fruit -> fruit.contains("a")).toList();
		fruitWithA.forEach(System.out::println);
		System.out.println();
	}

	protected void runWordsChallenges() {
		System.out.println("From the words list, find the longest word.");
		Optional<String> longestWord = words.stream().max(Comparator.comparing(String::length).reversed());
		System.out.println(longestWord.orElse("No word found"));
		System.out.println();

		System.out.println("From the words list, find the shortest word.");
		Optional<String> shortestWord = words.stream().min(Comparator.comparing(String::length));
		System.out.println(shortestWord.orElse("No word found"));
		System.out.println();

		System.out.println("From the words list, get all words sorted by their length (shortest first)");
		List<String> sortByLength = words.stream().sorted(Comparator.comparingInt(String::length)).toList();
		sortByLength.forEach(System.out::println);
		System.out.println();
	}

	protected void runPricesChallenges() {
		System.out.println("From the fruits list, Calculate the sum of all prices.");
		Double sumOfPrices = prices.stream().mapToDouble(Double::doubleValue).sum();
		System.out.println(sumOfPrices);
		System.out.println();

		System.out.println("From the fruits list, Find the maximum price.");
		OptionalDouble maxPrice = prices.stream().mapToDouble(Double::doubleValue).max();
		System.out.println(maxPrice.orElse(0));
		System.out.println();

		System.out.println("From the fruits list, Find the minimum price.");
		OptionalDouble minPrice = prices.stream().mapToDouble(Double::doubleValue).min();
		System.out.println(minPrice.orElse(0));
		System.out.println();

		System.out.println("From the fruits list, Calculate the average price.");
		OptionalDouble avgPrice = prices.stream().mapToDouble(Double::doubleValue).average();
		System.out.println(avgPrice.orElse(0));
		System.out.println();

		System.out.println("From the fruits list, Get all prices greater than 50, sorted in descending order.");
		List<Double> greaterThan50AndSortDesc = prices.stream().filter(price -> price > 50)
				.sorted(Comparator.comparingDouble(Double::doubleValue).reversed()).toList();
		greaterThan50AndSortDesc.forEach(System.out::println);
		System.out.println();
	}

}