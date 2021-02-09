package com.corejava.csv;

public class CustomerDb {

	private String CustomerNumber, CustomerName, ContactLastName, ContactFirstName, Phone, AddressLine1, AddressLine2,
			City, State, PostalCode, SalesRepoEmployeeNumber, CreditLimit;

	public String getContactFirstName() {
		return ContactFirstName;
	}

	public void setContactFirstName(String contactFirstName) {
		ContactFirstName = contactFirstName;
	}

	public String getCustomerNumber() {
		return CustomerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		CustomerNumber = customerNumber;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getContactLastName() {
		return ContactLastName;
	}

	public void setContactLastName(String contactLastName) {
		ContactLastName = contactLastName;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getAddressLine1() {
		return AddressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return AddressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getPostalCode() {
		return PostalCode;
	}

	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}

	public String getSalesRepoEmployeeNumber() {
		return SalesRepoEmployeeNumber;
	}

	public void setSalesRepoEmployeeNumber(String salesRepoEmployeeNumber) {
		SalesRepoEmployeeNumber = salesRepoEmployeeNumber;
	}

	public String getCreditLimit() {
		return CreditLimit;
	}

	public void setCreditLimit(String creditLimit) {
		CreditLimit = creditLimit;
	}

	@Override
	public String toString() {
		return "CustomerDb [CustomerNumber=" + CustomerNumber + ", CustomerName=" + CustomerName + ", ContactLastName="
				+ ContactLastName + ", ContactFirstName=" + ContactFirstName + ", Phone=" + Phone + ", AddressLine1="
				+ AddressLine1 + ", AddressLine2=" + AddressLine2 + ", City=" + City + ", State=" + State
				+ ", PostalCode=" + PostalCode + ", SalesRepoEmployeeNumber=" + SalesRepoEmployeeNumber
				+ ", CreditLimit=" + CreditLimit + "]";
	}

}
