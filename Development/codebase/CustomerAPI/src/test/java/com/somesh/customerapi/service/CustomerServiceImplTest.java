/**
 * 
 */
package com.somesh.customerapi.service;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.somesh.customerapi.CustomerAPICommonMethods;
import com.somesh.customerapi.dao.CustomerDao;
import com.somesh.customerapi.model.Customer;

/**
 * @author somesh.kusawaha
 *
 */
@DataJpaTest
class CustomerServiceImplTest {
	
	@Mock
	private CustomerDao customerDao;
	
	@InjectMocks
	private CustomerServiceImpl customerServiceImpl;
	
	/*************************************************************/
	/*****************getCustomersList()**************************/
	/*************************************************************/
	
	@Test
	void getCustomersListForSuccess() {
		List<Customer> customersList = null;
		when(customerDao.findAll()).thenReturn(CustomerAPICommonMethods.getCustomersListMock());
		customersList = customerServiceImpl.getCustomersList();
		assertNotNull(customersList);
	}
	
	/*************************************************************/
	/*****************getCustomerById()**************************/
	/*************************************************************/
	
	@Test
	void getCustomerByIdForSuccess() {
		Customer customer = null;
		when(customerDao.findById(any())).thenReturn(Optional.of(CustomerAPICommonMethods.getCustomerMock()));
		customer = customerServiceImpl.getCustomerById(CustomerAPICommonMethods.getCustomerMock().getId());
		assertNotNull(customer);
	}
	
	/*************************************************************/
	/*****************addNewCustomer()**************************/
	/*************************************************************/
	
	@Test
	void addNewCustomerForSuccess() {
		Customer customer = null;
		when(customerDao.save(any())).thenReturn(CustomerAPICommonMethods.getCustomerMock());
		customer = customerServiceImpl.addNewCustomer(CustomerAPICommonMethods.getCustomerMock());
		assertNotNull(customer);
	}
	
	/*************************************************************/
	/*****************editCustomer()**************************/
	/*************************************************************/
	
	@Test
	void editCustomerForSuccess() {
		Customer customer = null;
		when(customerDao.save(any())).thenReturn(CustomerAPICommonMethods.getCustomerMock());
		customer = customerServiceImpl.editCustomer(CustomerAPICommonMethods.getCustomerMock());
		assertNotNull(customer);
	}
	
	/*************************************************************/
	/*****************deleteCustomerById()**************************/
	/*************************************************************/
	
	@Test
	void deleteCustomerByIdForSuccess() {
		Boolean response = null;
		Mockito.doNothing().when(customerDao).deleteById(any());
		response = customerServiceImpl.deleteCustomerById(CustomerAPICommonMethods.getCustomerMock().getId());
		assertNotNull(response);
		assertTrue(response);
	}
	
	@Test
	void deleteCustomerByIdForException() {
		Boolean response = null;
		Mockito.doThrow(new IllegalArgumentException()).when(customerDao).deleteById(any());
		response = customerServiceImpl.deleteCustomerById(CustomerAPICommonMethods.getCustomerMock().getId());
		assertNotNull(response);
		assertFalse(response);
	}
}
