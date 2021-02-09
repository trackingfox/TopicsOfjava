package com.corejava.csv;

import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class CustomerCsvFileToObject {

	public List<CustomerDb> CustomercsvToclass() {

		// CustomerNumber, CustomerName, ContactLastName, ContactFirstName,Phone,
		// AddressLine1,
		// AddressLine2, City, State, PostalCode,
		// SalesRepoEmployeeNumber, CreditLimit

		// "customerNumber","customerName","contactLastName","contactFirstName","phone","addressLine1",
		// "addressLine2","city","state","postalCode","country","salesRepEmployeeNumber","creditLimit"

		// create a hashmap of column header to class attribute
		Map<String, String> mapper = new HashMap<String, String>();

		mapper.put("customerNumber", "CustomerNumber");
		mapper.put("customerName", "CustomerName");
		mapper.put("contactLastName", "ContactLastName");
		mapper.put("contactFirstName", "ContactFirstName");
		mapper.put("phone", "Phone");
		mapper.put("addressLine1", "AddressLine1");
		mapper.put("addressLine2", "AddressLine2");
		mapper.put("city", "City");
		mapper.put("state", "State");
		mapper.put("postalCode", "PostalCode");
		mapper.put("salesRepEmployeeNumber", "SalesRepoEmployeeNumber");
		mapper.put("creditLimit", "CreditLimit");

		// HeaderColumnNameTranslateMappingStrategy
		// for Country class
		HeaderColumnNameTranslateMappingStrategy<CustomerDb> strategy = new HeaderColumnNameTranslateMappingStrategy<CustomerDb>();
		strategy.setType(CustomerDb.class);
		strategy.setColumnMapping(mapper);

		// csvReader
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader(
					"D:\\Workspace\\TopicsOfjava\\src\\main\\java\\com\\corejava\\csv\\customerDBSample.csv"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		// csv to bean
		CsvToBean csvBean = new CsvToBean();

		// call the parse method
		List<CustomerDb> customerlist = csvBean.parse(strategy, csvReader);
		for (CustomerDb customerDb : customerlist) {
			System.out.println(customerDb);

		}

		return customerlist;
	}

	@Test
	public void CustomerDetals() {
		List<CustomerDb> custlist = CustomercsvToclass();

	}

}
