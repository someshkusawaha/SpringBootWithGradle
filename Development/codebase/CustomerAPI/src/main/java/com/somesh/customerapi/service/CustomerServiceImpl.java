/**
 * 
 */
package com.somesh.customerapi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somesh.customerapi.dao.CustomerDao;
import com.somesh.customerapi.model.Customer;

/**
 * @author somesh.kusawaha
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService{

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<Customer> getCustomersList() {
		LOGGER.info("CustomerServiceImpl : getCustomersList() method start");
		LOGGER.info("CustomerServiceImpl : getCustomersList() method end");
		return customerDao.findAll();
	}

	@Override
	public Customer getCustomerById(Integer id) {
		LOGGER.info("CustomerServiceImpl : getCustomerById() method start");
		LOGGER.info("CustomerServiceImpl : getCustomerById() method end");
		return customerDao.findById(id).orElse(null);
	}

	@Override
	public Customer addNewCustomer(Customer customer) {
		LOGGER.info("CustomerServiceImpl : addNewCustomer() method start");
		LOGGER.info("CustomerServiceImpl : addNewCustomer() method end");
		return customerDao.save(customer);
	}

	@Override
	public Customer editCustomer(Customer customer) {
		LOGGER.info("CustomerServiceImpl : editCustomer() method start");
		LOGGER.info("CustomerServiceImpl : editCustomer() method end");
		return customerDao.save(customer);
	}

	@Override
	public Boolean deleteCustomerById(Integer id) {
		LOGGER.info("CustomerServiceImpl : deleteCustomerById() method start");
		Boolean response = null;
		try {
			customerDao.deleteById(id);
			response = Boolean.TRUE;
		}catch(Exception exception) {
			LOGGER.info("CustomerServiceImpl : Exception in deleteCustomerById() method : {}",exception.getMessage());
			response = Boolean.FALSE;
		}
		LOGGER.info("CustomerServiceImpl : deleteCustomerById() method end");
		return response;
	}

}
