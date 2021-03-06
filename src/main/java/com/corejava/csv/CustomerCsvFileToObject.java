package com.corejava.csv;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class CustomerCsvFileToObject {

	public List<CustomerTemp> CustomercsvToclass() {

		// CustomerNumber, CustomerName, ContactLastName, ContactFirstName,Phone,
		// AddressLine1,
		// AddressLine2, City, State, PostalCode,Country
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
		mapper.put("country", "Country");
		mapper.put("salesRepEmployeeNumber", "SalesRepoEmployeeNumber");
		mapper.put("creditLimit", "CreditLimit");

		// HeaderColumnNameTranslateMappingStrategy
		// for Country class
		HeaderColumnNameTranslateMappingStrategy<CustomerTemp> strategy = new HeaderColumnNameTranslateMappingStrategy<CustomerTemp>();
		strategy.setType(CustomerTemp.class);
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
		List<CustomerTemp> customerlist = csvBean.parse(strategy, csvReader);
//		for (CustomerTemp customerDb : customerlist) {
//			System.out.println(customerDb);
//
//		}

		return customerlist;
	}

	@Test
	public void CustomerDetals() {
		List<CustomerTemp> custlist = CustomercsvToclass();
		// Convert customertemp objects, customertemp list to customer list
//		List<Customer> custlist1 = custlist.stream().map(x -> x.getSalesRepoEmployeeNumber().equals("") ? null
//				: Integer.parseInt(x.getSalesRepoEmployeeNumber())).collect(Collectors.toList());

		List<Customer> custlist2 = new ArrayList<Customer>();
		for (CustomerTemp cust : custlist) {
			// 3.convert customertemp list to customer list
			Customer cust2 = new Customer();

			Integer a = cust.getSalesRepoEmployeeNumber().equals("") ? null
					: Integer.parseInt(cust.getSalesRepoEmployeeNumber());
			cust2.setSalesRepoEmployeeNumber(a);

			cust2.setCustomerName(cust.getCustomerName());

			int b = Integer.valueOf(cust.getCustomerNumber());
			cust2.setCustomerNumber(b);

			cust2.setAddressLine1(cust.getAddressLine1());
			cust2.setAddressLine2(cust.getAddressLine2());
			cust2.setContactFirstName(cust.getContactFirstName());
			cust2.setContactLastName(cust.getContactLastName());
			cust2.setCountry(cust.getCountry());

			Float c = Float.valueOf(cust.getCreditLimit());
			cust2.setCreditLimit(c);

			cust2.setPhone(cust.getPhone());
			cust2.setPostalCode(cust.getPostalCode());
			cust2.setState(cust.getState());
			cust2.setCity(cust.getCity());

			custlist2.add(cust2);
		}

//		for (Customer customer : custlist2) {
//			System.out.println(customer);
//
//		}
		// 1.convert customertemp list to customer list using interface

		// 2 convert customertemp list to customer list using stream

		List<Customer> custlist1 = new ArrayList<Customer>();
		custlist1 = custlist.stream().map(cust -> {

			Customer cust2 = new Customer();

			Integer a = cust.getSalesRepoEmployeeNumber().equals("") ? null
					: Integer.parseInt(cust.getSalesRepoEmployeeNumber());
			cust2.setSalesRepoEmployeeNumber(a);

			cust2.setCustomerName(cust.getCustomerName());

			int b = Integer.valueOf(cust.getCustomerNumber());
			cust2.setCustomerNumber(b);

			cust2.setAddressLine1(cust.getAddressLine1());
			cust2.setAddressLine2(cust.getAddressLine2());
			cust2.setContactFirstName(cust.getContactFirstName());
			cust2.setContactLastName(cust.getContactLastName());
			cust2.setCountry(cust.getCountry());

			Float c = Float.valueOf(cust.getCreditLimit());
			cust2.setCreditLimit(c);

			cust2.setPhone(cust.getPhone());
			cust2.setPostalCode(cust.getPostalCode());
			cust2.setState(cust.getState());
			cust2.setCity(cust.getCity());

			return cust2;
		}).collect(Collectors.toList());

		for (Customer customer : custlist1) {
			System.out.println(customer);

		}

	}
}
