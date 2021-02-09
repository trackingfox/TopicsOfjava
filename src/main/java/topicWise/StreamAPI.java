package topicWise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamAPI {
	@Test
	public void basic() {
		/*
		 * A Stream in Java 8 can be defined as a sequence of elements from a source.
		 * Streams supports aggregate operations on the elements. The source of elements
		 * here refers to a Collection or Array that provides data to the Stream.
		 * 
		 * Stream keeps the ordering of the elements the same as the ordering in the
		 * source. The aggregate operations are operations that allow us to express
		 * common manipulations on stream elements quickly and clearly.
		 */

		// # 2.1. Stream.of()
		// ## creating a stream of a fixed number of integers.
		Stream<Integer> str = Stream.of(1, 2, 3, 4);
		str.forEach(x -> System.out.println(x));

		// # 2.2. Stream.of(array)
		// ## Creating a stream from the array. The elements in the stream are taken
		// from the array.
		Integer myIntegerArray[] = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Stream<Integer> str2 = Stream.of(myIntegerArray);
		str2.forEach(x -> System.out.println(x));

		//

		//
		// # 2.3. List.stream()
		// ## Creating a stream from the List. The elements in the stream are taken from
		// the List.
		List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5);
		Stream<Integer> stream1 = numberList.stream();
		stream1.forEach(x -> System.out.println(x));

		List<String> words = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");
		Stream<String> stream2 = words.stream();
		stream2.forEach(x -> System.out.println(x));

		//
		//
		//
		// # 2.4. Stream.generate() or Stream.iterate()
		// ## Creating a stream from generated elements. This will produce a stream of
		// 20 random numbers. We have restricted the elements count using limit()
		// function.
		//

		Stream<Integer> ran = Stream.generate(() -> {
			Random a = new Random();
			return a.nextInt(10);
		});
		ran.limit(20).forEach(x -> System.out.println(x));

		//
		// # 2.5. Stream of String chars or tokens
		//
		// ## First, creating a stream from the characters of a given string. In the
		// second part, we are creating the stream of tokens received from splitting
		// from a string.
		//
		//

		//

		//
		//
		//
		//
		// # 4. Stream Operations
		// Stream abstraction has a long list of useful functions. Let us look at a few
		// of them.
		//
		// ## build a List of strings beforehand. We will build our examples on this
		// list so that it is easy to relate and understand.

		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Shekhar");
		memberNames.add("Aman");
		memberNames.add("Rahul");
		memberNames.add("Shahrukh");
		memberNames.add("Salman");
		memberNames.add("Yana");
		memberNames.add("Lokesh");
		//
		// These core methods have been divided into 2 parts given below:
		//
		// # 4.1. Intermediate Operations
		// Intermediate operations return the stream itself so you can chain multiple
		// methods calls in a row. Let’s learn important ones.
		//
		// # 4.1.1. Stream.filter()
		//
		// The filter() method accepts a Predicate to filter all elements of the stream.
		// This operation is intermediate which enables us to call another stream
		// operation (e.g. forEach()) on the result.
		//
		// ## Write an example that filters a list of strings starting with 'A' and
		// prints them
		//
		for (String i : memberNames) {
			if (i.startsWith("A"))
				System.out.println(i);
		}

		Stream<String> stream3 = memberNames.stream();
		Stream<String> stream4 = stream3.filter(i -> i.startsWith("A"));
		stream4.forEach(x -> System.out.println(x));

		memberNames.stream().filter(i -> i.startsWith("A")).forEach(System.out::println);

		//
		//
		// # 4.1.2. Stream.map()
		// The map() intermediate operation converts each element in the stream into
		// another object via the given function.
		//
		// ## Write an example that converts each string into an UPPERCASE string. But
		// we can use map() to transform an object into another type as well.
		//
		memberNames.stream().map(i -> i.toUpperCase()).forEach(System.out::println);
		memberNames.stream().map(String::toUpperCase).forEach(System.out::println);
//		memberNames.stream().forEach(x -> System.out.println(x.toUpperCase()));
		//
		// # 4.1.2. Stream.sorted()
		// The sorted() method is an intermediate operation that returns a sorted view
		// of the stream. The elements in the stream are sorted in natural order unless
		// we pass a custom Comparator.
		//
		// ## Given a list of strings, write an example that SORTS and then converts
		// each string into an UPPERCASE string. But we can use map() to transform an
		// object into another type as well.
		//
//		    memberNames.stream().sorted()
//		                        .map(String::toUpperCase)
//		                        .forEach(System.out::println);
		//
//		    Program Output:
//		    AMAN
//		    AMITABH
//		    LOKESH
//		    RAHUL
//		    SALMAN
//		    SHAHRUKH
//		    SHEKHAR
//		    YANA
		//
//		    Please note that the sorted() method only creates a sorted view of the stream without manipulating the ordering of the source Collection. In this example, the ordering of string in the memberNames is untouched.
		//
		// # 4.2. Terminal operations
		//
		// Terminal operations return a result of a certain type after processing all
		// the stream elements.
		// Once the terminal operation is invoked on a Stream, the iteration of the
		// Stream and any of the chained streams will get started. Once the iteration is
		// done, the result of the terminal operation is returned.
		//
		// # 4.2.1. Stream.forEach()
		//
		// The forEach() method helps in iterating over all elements of a stream and
		// perform some operation on each of them. The operation to be performed is
		// passed as the lambda expression.
		//
		// ## Given a list of strings, use foreach to
		//

		//
		// # 4.2.2. Stream.collect()
		//
//		    The collect() method is used to receive elements from a steam and store them in a collection.
//		    List<String> memNamesInUppercase = memberNames.stream().sorted()
//		                                .map(String::toUpperCase)
//		                                .collect(Collectors.toList());
//		        
//		    System.out.print(memNamesInUppercase);
		//
//		    Program Output:
//		    [AMAN, AMITABH, LOKESH, RAHUL, SALMAN, SHAHRUKH, SHEKHAR, YANA]

		// convert a list of string which starts with 'A' to uppercase and return a list

		List<String> list1 = memberNames.stream().filter(i -> i.startsWith("A")).map(x -> x.toUpperCase())
				.collect(Collectors.toList());
		System.out.println();

		list1.forEach(System.out::println);

		List<String> list2 = new ArrayList();
		for (String i : memberNames) {
			if (i.startsWith("A"))
				list2.add(i.toUpperCase());
		}
		System.out.println();
		for (String j : list2) {

			System.out.println(j);
		}

		// # 3. Stream Collectors
		//
		// ## After performing the intermediate operations on elements in the stream, we
		// can collect the processed elements again into a Collection using the stream
		// Collector methods.
		//

		// # 3.1. Collect Stream elements to a List
		//
		// ## first, we are creating a stream on integers 1 to 10. Then we are
		// processing the stream elements to find all even numbers. At last, we are
		// collecting all even numbers into a List.
		//
		//
		//
		//
		// # 3.2. Collect Stream elements to an Array
		//
		// ## Write an code similar to the first example shown above. The only
		// difference is that we are collecting the even numbers in an Array. There are
		// plenty of other ways also to collect stream into a Set, Map or into multiple
		// ways. Just go through Collectors class and try to keep them in mind.
		//
		//

		/*
		 * PROBLEMS
		 * 
		 * 
		 */
		// Create an integer array. Convert into integer list. Find all the multiples of
		// 3 and return an integer array

		List<Integer> list3 = Arrays.asList(myIntegerArray).stream().filter(x -> x % 3 == 0)
				.collect(Collectors.toList());
		list3.forEach(System.out::println);

		// Integer arr[] = list3.toArray(new Integer[list3.size()]);
		Integer arr[] = list3.toArray(Integer[]::new);

		for (Integer i : arr) {
			System.out.println(i);

		}

		Integer ar[] = Arrays.asList(myIntegerArray).stream().filter(x -> x % 3 == 0).toArray(Integer[]::new);
		for (Integer i : ar) {
			System.out.println(i);

		}

		// NOTES : Stream.toArray(type of array :: new)
		// stream.collect(Collectors.toList())

	}

}
