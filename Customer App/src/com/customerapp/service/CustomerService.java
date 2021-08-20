package com.customerapp.service;

import com.customerapp.entities.Customer;
import com.customerapp.exceptions.CustomerNotFoundException;
import com.customerapp.exceptions.DaoException;

public interface CustomerService {
	public Customer addCustomer(Customer customer) throws DaoException;
	public Customer findCustomerById(int id) throws CustomerNotFoundException;
}
