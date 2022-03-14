/**
 * 
 */
package com.somesh.customerapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.somesh.customerapi.model.Customer;
import com.somesh.customerapi.service.CustomerService;

/**
 * @author somesh.kusawaha
 *
 */
@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("")
	public ResponseEntity<List<Customer>> getCustomersList(){
		LOGGER.info("CustomerController : getCustomersList() method start");
		List<Customer> customersList = null;
		try {
			customersList = customerService.getCustomersList();
		}catch(Exception exception) {
			LOGGER.error("CustomerController : Exception in getCustomersList() method : {}",exception.getMessage());
		}
		LOGGER.info("CustomerController : getCustomersList() method end");
		return new ResponseEntity<>(customersList,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id){
		LOGGER.info("CustomerController : getCustomerById() method start");
		Customer customer = null;
		ResponseEntity<Customer> responseEntity = null;
		try {
			customer = customerService.getCustomerById(id);
			if(customer != null) {
				responseEntity = new ResponseEntity<>(customer,HttpStatus.OK);
			}else {
				responseEntity = new ResponseEntity<>(customer,HttpStatus.NOT_FOUND);
			}
		}catch(Exception exception) {
			LOGGER.error("CustomerController : Exception in getCustomersList() method : {}",exception.getMessage());
		}
		LOGGER.info("CustomerController : getCustomerById() method end");
		return responseEntity;
	}

	@PostMapping("")
	public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer customer) {
		LOGGER.info("CustomerController : addNewCustomer() method start");
		ResponseEntity<Customer> responseEntity = null;
		try {
			customer = customerService.addNewCustomer(customer);
			if(customer != null) {
				responseEntity = new ResponseEntity<>(customer,HttpStatus.CREATED);
			}
		}catch(Exception exception) {
			LOGGER.error("CustomerController : Exception in addNewCustomer() method : {}",exception.getMessage());
			responseEntity = new ResponseEntity<>(customer,HttpStatus.NO_CONTENT);
		}
		LOGGER.info("CustomerController : addNewCustomer() method end");
		return responseEntity;
	}
	
	@PutMapping("")
	public ResponseEntity<Customer> editCustomer(@RequestBody Customer customer) {
		LOGGER.info("CustomerController : editCustomer() method start");
		ResponseEntity<Customer> responseEntity = null;
		try {
			customer = customerService.editCustomer(customer);
			if(customer != null) {
				responseEntity = new ResponseEntity<>(customer,HttpStatus.OK);
			}else {
				responseEntity = new ResponseEntity<>(customer,HttpStatus.NOT_FOUND);
			}
		}catch(Exception exception) {
			LOGGER.error("CustomerController : Exception in editCustomer() method : {}",exception.getMessage());
		}
		LOGGER.info("CustomerController : editCustomer() method end");
		return responseEntity;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteCustomerById(@PathVariable Integer id) {
		LOGGER.info("CustomerController : deleteCustomerById() method start");
		ResponseEntity<Boolean> responseEntity = null;
		Boolean response = Boolean.FALSE;
		try {
			response = customerService.deleteCustomerById(id);
			if(Boolean.TRUE.equals(response)) {
				responseEntity = new ResponseEntity<>(response,HttpStatus.OK);
			}else {
				responseEntity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			}
		}catch(Exception exception) {
			LOGGER.error("CustomerController : Exception in deleteCustomerById() method : {}",exception.getMessage());
		}
		LOGGER.info("CustomerController : deleteCustomerById() method end");
		return responseEntity;
	}
}
