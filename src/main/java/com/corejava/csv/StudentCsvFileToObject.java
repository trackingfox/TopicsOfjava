package com.corejava.csv;

import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class StudentCsvFileToObject {

	// name,rollno,department,result,cgpa
	// @Test
	public List<Student> csvToclass() {
		// create a hashmap of colmn header to class attribute

		Map<String, String> mapper = new HashMap<String, String>();

		mapper.put("name", "Name");
		mapper.put("rollno", "RollNo");
		mapper.put("department", "Department");
		mapper.put("result", "Result");
		mapper.put("cgpa", "Pointer");

		// HeaderColumnNameTranslateMappingStrategy
		// for Student class
		HeaderColumnNameTranslateMappingStrategy<Student> strategy = new HeaderColumnNameTranslateMappingStrategy<Student>();
		strategy.setType(Student.class);
		strategy.setColumnMapping(mapper);

		// csvReader
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader(
					"D:\\Workspace\\TopicsOfjava\\src\\main\\java\\com\\corejava\\csv\\StudentData.csv"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		// csv to bean
		CsvToBean csvBean = new CsvToBean();

		// call the parse method
		List<Student> stulist = csvBean.parse(strategy, csvReader);
//			 System.out.println(stu);
//		for (Student stu1 : stu) {
//			 System.out.println(stu1);
//
//		}

		return stulist;
	}

	@Test
	public void StudentTransaction() {
		List<Student> studentlist = csvToclass();
		// Get student with exact match name "rohini"
		Optional<Student> a = studentlist.stream().filter(x -> x.getName().equals("rohini")).findFirst();
//		a.ifPresent(System.out::println);
//		a.ifPresent(x -> System.out.println(x));

//		Optional<Student> a = Optional.ofNullable(studentlist.stream().filter(x -> x.getName().equals("rohini")));
//		a.ifPresent(System.out::println);
//		a.ifPresent(x -> System.out.println(x));

		// Get student with matching roll "21"
		Optional<Student> b = studentlist.stream().filter(x -> x.getRollNo().equals("21")).findFirst();
//		b.ifPresent(System.out::println);
		// Get all student having department "cse"
		List<Student> cseStudent = studentlist.stream().filter(x -> x.getDepartment().equals("cse"))
				.collect(Collectors.toList());
//		for (Student student : cseStudent) {
//			System.out.println(student);
//		}
		// Get all student having department "cse" and "ee"
		List<Student> cseEEStudent = studentlist.stream()
				.filter(x -> (x.getDepartment().equals("cse") || x.getDepartment().equals("ee")))
				.collect(Collectors.toList());
		for (Student student : cseEEStudent) {
			System.out.println(student);
		}

		// Create a List<Student> from the List<TempStudent>

		// Convert List<Student> to List<String> of student names

		// Convert List<students> to String

		// Change the case of List<String>

		// Sort List<String>

		// Conditionally apply Filter condition, say if flag is enabled then

	}

}
