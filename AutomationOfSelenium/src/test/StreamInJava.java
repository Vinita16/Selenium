package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.remote.NewSessionPayload;
import org.testng.annotations.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamInJava {

	public static void main(String[] args) {

		ArrayList<String> names = new ArrayList<String>();
		names.add("Vinita");
		names.add("Avi");
		names.add("amber");
		names.add("apurva");
		int count = 0;

		for (int i = 0; i < names.size(); i++) {

			String nameString = names.get(i);
			if (nameString.startsWith("A"))
				;
			{
				count++;

			}

			System.out.println(count);

		}
	}

	@Test

	public void getName() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Vinita");
		names.add("Avi");
		names.add("amber");
		names.add("apurva");
		Long c = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);

		long d = Stream.of("Vinita", "Vinso", "vini").filter(s ->

		{
			s.startsWith("V");
			return true;

		}).count();
		System.out.println(d);

		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));

	}

	@Test

	public void streamMap() {

		ArrayList<String> names = new ArrayList<String>();
		names.add("Vinita");
		names.add("Avi");
		names.add("amber");
		names.add("apurva");

		Stream.of("Vinita", "Vinso", "vini").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		List<String> names1 = Arrays.asList("Yeah", "ya", "yss", "yellow");
		names1.stream().filter(s -> s.startsWith("y")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		newStream.sorted().forEach(s -> System.out.println(s));
	}

	@Test

	public void convertCollect() {

		List<String> newList = Stream.of("Vinita", "Vinso", "vini").filter(s -> s.endsWith("o"))
				.map(s -> s.toUpperCase()).collect(Collectors.toList());
		newList.get(0);
		System.out.println(newList.get(0));

		List<Integer> numbers = Arrays.asList(3, 2, 4, 5, 5, 5, 6);
		numbers.stream().distinct().forEach(s -> System.out.println(s));
		List<Integer> number = numbers.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(number.get(2));
	}

}
