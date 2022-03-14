/**
 * 
 */
package com.somesh.customerapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.somesh.customerapi.model.Customer;

/**
 * @author somesh.kusawaha
 *
 */
@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
