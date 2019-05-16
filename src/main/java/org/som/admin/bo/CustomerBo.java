package org.som.admin.bo;

import java.security.InvalidKeyException;
import java.util.List;

import org.apache.kafka.common.errors.InvalidRequestException;
import org.som.bean.CustomerFormBean;
import org.som.bean.model.Customer;
import org.som.util.EnumInterface;
import org.springframework.security.core.Authentication;

public interface CustomerBo
{
	Customer getCustomer(CustomerFormBean request);

	EnumInterface saveCustomer(Authentication auth, CustomerFormBean request) throws InvalidKeyException;

	EnumInterface updateCustomer(Authentication auth, CustomerFormBean request);

	EnumInterface blockCustomer(Authentication auth, CustomerFormBean request);

	List<Customer> getCustomerByName(CustomerFormBean request);

	EnumInterface checkCustomerExist(CustomerFormBean request);

	List<Customer>  getCustomerList();
	
	EnumInterface blockCustomerById(Authentication auth, CustomerFormBean request);
	
	EnumInterface deleteCustomer(Authentication auth, CustomerFormBean cfBean) throws InvalidRequestException;
}
