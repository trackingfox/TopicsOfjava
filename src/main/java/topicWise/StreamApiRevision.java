package topicWise;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamApiRevision {
	// Basic revision
	// @Test
	public void Revision() {

		Integer[] nums = new Integer[] { 1, 2, 4, 5, 7, 8, 6 };
		int[] pnums = new int[] { 4, 12, 44, 15, 17, 28, 26 };

//		# convert a array of primitive int to list of Integer ; square them and return  an Integer array

		Integer[] pnum1 = Arrays.stream(pnums).boxed().toArray(Integer[]::new);
		// System.out.println(pnum1);
		for (Integer i : pnum1) {
			// System.out.println(i);

		}

		Integer[] array1 = Arrays.stream(pnums).boxed().map(x -> x * x).toArray(Integer[]::new);
		System.out.println(array1);
		for (Integer integer : array1) {
			System.out.println(integer);
		}

		List<Integer> pnum2 = Arrays.stream(pnums).boxed().collect(Collectors.toList());
		// System.out.println(pnum2);

		List<Integer> pnum3 = Stream.of(nums).collect(Collectors.toList());
		// System.out.println(pnum3);

		// # create a list of int of all even numbers from 1 to 20
		List<Integer> list3 = IntStream.range(0, 100).filter(x -> x % 2 == 0).boxed().collect(Collectors.toList());
		System.out.println(list3);

		// create an array of int
		int[] Array2 = IntStream.range(0, 100).filter(x -> x % 2 == 0).toArray();
		System.out.println(Array2);
		for (int i : Array2) {
			System.out.println(i);
		}

		// from existing int[] return another int[] with even nos.
		int[] array3 = Arrays.stream(pnums).filter(x -> x % 3 == 0).toArray();
		for (int i : array3) {
			System.out.println(i);
		}

		// from existing Integer[] return another Integer[] with even nos.

		Integer[] array4 = Stream.of(nums).filter(x -> x % 2 == 0).toArray(Integer[]::new);
		System.out.println(array4);
		for (Integer integer : array4) {
			System.out.println(integer);
		}

		// # create a list of Integers of all even numbers from 1 to 20

		// # convert a primitive int Array to list of Integer ; square them and return a
		// list of int

		// To a list

		// To an Integer Array

		// To an int Array

		// List of Integers -> return list of Integers only even numbers
	}

	@Test
	public void reduceExample() {

		Integer[] nums = new Integer[] { 1, 2, 4, 5, 7, 8, 6 };
		int[] pnums = new int[] { 4, 12, 44, 15, 17, 28, 26 };

//		# 4.2.5. Stream.reduce()
//		The reduce() method performs a reduction on the elements of the stream with the given function. 
//		The result is an Optional holding the reduced value.

		// Find the product of all elements in an int[]

		int product = Arrays.stream(pnums).boxed().reduce(1, (x1, x2) -> x1 * x2);
		System.out.println(product);
		int product_1 = 1;
		for (int i : pnums) {
			product_1 = product_1 * i;

		}
		System.out.println(product_1);

		//// Find the sum of all elements in an Integer[]

		int sum = Stream.of(nums).reduce(0, (x, y) -> x + y);
		System.out.println(sum);

		int sum2 = 0;
		for (int i : nums) {
			sum2 += i;

		}
		System.out.println(sum2);

//-------------------------------------------------------------------------------------------------------
//		reduce with strings		
		String[] str = { "Alex", "Brian", "Charles", "how", "to", "do", "in", "java" };
		List<String> liststr = Arrays.asList(str);
		// System.out.println(liststr);

		// Find the longest word from str
		String longest = Arrays.asList(str).stream().reduce("null", (x1, x2) -> x1.length() > x2.length() ? x1 : x2);
		// System.out.println(longest);

		// Find the word with lenth greater than 4
		String longest1 = Arrays.asList(str).stream().filter(x -> x.length() > 4).collect(Collectors.toList()).get(1);
		System.out.println("Hello" + longest1);

		// Concatenate to single string with ! in between
		Optional<String> largestr = Arrays.asList(str).stream().reduce((x1, x2) -> x1 + "!" + x2);
		largestr.ifPresentOrElse(System.out::println, () -> System.out.println("not found"));
		// System.out.println(largestr);

		Optional<String> largestr1 = Arrays.asList(str).stream()
				.reduce((x1, x2) -> x1.length() > 4 ? x1 + "!" + x2 : x2);
		largestr1.ifPresentOrElse(System.out::println, () -> System.out.println("not found"));

		//// ADD elements of an array with length > 4 separated by '!'
//Method 1
		Optional<String> largestr2 = Arrays.asList(str).stream().filter(x -> x.length() > 4)
				.reduce((x, y) -> x + "!" + y);
		System.out.println(largestr2);
//Method 2		
		Optional<String> largestr3 = Arrays.asList(str).stream().reduce((x, y) -> {
			if (x.length() > 3 && y.length() > 3)
				return x + "!" + y;
			else if (x.length() > 3)
				return x;

			else if (y.length() > 3)
				return y;
			return "";
		});
		System.out.println(largestr3);

	}

}