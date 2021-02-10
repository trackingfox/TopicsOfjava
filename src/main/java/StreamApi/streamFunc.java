package StreamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class streamFunc {
	@Test
	public void StreamBuilders() {
//		Stream<Integer> randomNumbers = Stream.generate(() -> (new Random()).nextInt(100));
//		randomNumbers.limit(20).forEach(System.out::println);

		IntStream stream = "12345_abcdefg".chars();
		stream.forEach(p -> System.out.println(p));

		// sorted
		List<Integer> list1 = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
		List<Integer> sortedList = list1.stream().sorted().collect(Collectors.toList());

		System.out.println(sortedList);

		// sorted using comparator
		List<Integer> list2 = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
		List<Integer> sortedList1 = list2.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

		System.out.println(sortedList1);

		// sorting stream using lambda exp
		List<Integer> list3 = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
		List<Integer> sortedList2 = list3.stream().sorted((i1, i2) -> i2.compareTo(i1)).collect(Collectors.toList());

		System.out.println(sortedList2);

		// FIND FIRST()
		// sequential stream
		Stream.of("one", "two", "three", "four").findFirst().ifPresent(System.out::println);

		// parallel stream
		Stream.of("one", "two", "three", "four").parallel().findFirst().ifPresent(System.out::println);

		// FINDANY()
		// sequential stream
		Stream.of("one", "two", "three", "four").findAny().ifPresent(System.out::println);

		// parallel stream
		Stream.of("one", "two", "three", "four").parallel().findAny().ifPresent(System.out::println);

	}

}
