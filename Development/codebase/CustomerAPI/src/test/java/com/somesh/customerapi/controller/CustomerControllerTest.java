/**
 * 
 */
package com.somesh.customerapi.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.somesh.customerapi.CustomerAPICommonMethods;
import com.somesh.customerapi.service.CustomerService;

/**
 * @author somesh.kusawaha
 *
 */

@ExtendWith(SpringExtension.class)
@WebMvcTest
class CustomerControllerTest {
	
	@MockBean
	private CustomerService customerService;
	
	@Autowired
	private MockMvc mockMvc;
	
	/*************************************************************/
	/*****************getCustomersList()**************************/
	/*************************************************************/
	
	@Test
	void getCustomersListForSuccess() throws Exception {
		when(customerService.getCustomersList()).thenReturn(CustomerAPICommonMethods.getCustomersListMock());
		mockMvc.perform(get("/customer")).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	void getCustomersListForException() throws Exception {
		when(customerService.getCustomersList()).thenThrow(new NullPointerException());
		mockMvc.perform(get("/customer")).andExpect(status().isOk()).andReturn();
	}
	

	/*************************************************************/
	/*****************getCustomerById()**************************/
	/*************************************************************/
	
	@Test
	void getCustomerByIdForSuccess() throws Exception {
		when(customerService.getCustomerById(any())).thenReturn(CustomerAPICommonMethods.getCustomerMock());
		mockMvc.perform(get("/customer/1")).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	void getCustomerByIdForNull() throws Exception {
		when(customerService.getCustomerById(any())).thenReturn(null);
		mockMvc.perform(get("/customer/1")).andExpect(status().isNotFound()).andReturn();
	}
	
	@Test
	void getCustomerByIdForException() throws Exception {
		when(customerService.getCustomerById(any())).thenThrow(new NullPointerException());
		mockMvc.perform(get("/customer/1")).andExpect(status().isOk()).andReturn();
	}
	
	/*************************************************************/
	/*****************addNewCustomer()**************************/
	/*************************************************************/
	
	@Test
	void addNewCustomerForSuccess() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(CustomerAPICommonMethods.getCustomerMock());
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/customer").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(json).flashAttr("customer", CustomerAPICommonMethods.getCustomerMock());
		when(customerService.addNewCustomer(any())).thenReturn(CustomerAPICommonMethods.getCustomerMock());
		mockMvc.perform(builder).andExpect(status().isCreated()).andReturn();
	}
	
	@Test
	void addNewCustomerForException() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(CustomerAPICommonMethods.getCustomerMock());
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/customer").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(json).flashAttr("customer", CustomerAPICommonMethods.getCustomerMock());
		when(customerService.addNewCustomer(any())).thenThrow(new NullPointerException());
		mockMvc.perform(builder).andExpect(status().isNoContent()).andReturn();
	}
	
	/*************************************************************/
	/*****************editCustomer()**************************/
	/*************************************************************/
	
	@Test
	void editCustomerForSuccess() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(CustomerAPICommonMethods.getCustomerMock());
		when(customerService.editCustomer(any())).thenReturn(CustomerAPICommonMethods.getCustomerMock());
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/customer").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(json).flashAttr("customer", CustomerAPICommonMethods.getCustomerMock());
		mockMvc.perform(builder).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	void editCustomerForNull() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(CustomerAPICommonMethods.getCustomerMock());
		when(customerService.editCustomer(any())).thenReturn(null);
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/customer").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(json).flashAttr("customer", CustomerAPICommonMethods.getCustomerMock());
		mockMvc.perform(builder).andExpect(status().isNotFound()).andReturn();
	}
	
	@Test
	void editCustomerForException() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(CustomerAPICommonMethods.getCustomerMock());
		when(customerService.editCustomer(any())).thenThrow(new NullPointerException());
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/customer").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(json).flashAttr("customer", CustomerAPICommonMethods.getCustomerMock());
		mockMvc.perform(builder).andExpect(status().isOk()).andReturn();
	}
	
	/*************************************************************/
	/*****************deleteCustomerById()**************************/
	/*************************************************************/
	
	@Test
	void deleteCustomerByIdForSuccess() throws Exception {
		when(customerService.deleteCustomerById(any())).thenReturn(Boolean.TRUE);
		mockMvc.perform(delete("/customer/1")).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	void deleteCustomerByIdForNull() throws Exception {
		when(customerService.deleteCustomerById(any())).thenReturn(Boolean.FALSE);
		mockMvc.perform(delete("/customer/1")).andExpect(status().isNotFound()).andReturn();
	}
	
	@Test
	void deleteCustomerByIdForException() throws Exception {
		when(customerService.deleteCustomerById(any())).thenThrow(new NullPointerException());
		mockMvc.perform(delete("/customer/1")).andExpect(status().isOk()).andReturn();
	}
}
