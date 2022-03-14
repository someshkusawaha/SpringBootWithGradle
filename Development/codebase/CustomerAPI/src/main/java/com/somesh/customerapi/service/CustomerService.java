/**
 * 
 */
package com.somesh.customerapi.service;

import java.util.List;

import com.somesh.customerapi.model.Customer;

/**
 * @author somesh.kusawaha
 *
 */
public interface CustomerService {

	public List<Customer> getCustomersList();
	
	public Customer getCustomerById(Integer id);
	
	public Customer addNewCustomer(Customer customer);
	
	public Customer editCustomer(Customer customer);
	
	public Boolean deleteCustomerById(Integer id);
}
