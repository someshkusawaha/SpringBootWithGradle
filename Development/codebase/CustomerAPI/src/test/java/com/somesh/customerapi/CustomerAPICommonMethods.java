package com.somesh.customerapi;

import java.util.ArrayList;
import java.util.List;

import com.somesh.customerapi.model.Customer;

public class CustomerAPICommonMethods {

	private CustomerAPICommonMethods() {}
	
	public static Customer getCustomerMock() {
		Customer customer = new Customer();
		customer.setId(1);
		customer.setFirstName("Somesh");
		customer.setSurName("Kusawaha");
		customer.setSmoothiePreference("fruits");
		customer.setMobileNumber("+91-9000000001");
		return customer;
	}
	
	public static List<Customer> getCustomersListMock(){
		List<Customer> customersList = new ArrayList<>();
		customersList.add(getCustomerMock());
		return customersList;
	}
}
