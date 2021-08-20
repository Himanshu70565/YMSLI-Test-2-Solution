package com.customerapp.service;


import com.customerapp.dao.CustomerDao;
import com.customerapp.dao.CustomerDaoImpl;
import com.customerapp.entities.Customer;
import com.customerapp.exceptions.CustomerNotFoundException;
import com.customerapp.exceptions.DaoException;

public class CustomerServiceImpl implements CustomerService{

	private CustomerDao customerDao;
	
	public CustomerServiceImpl() {
		customerDao=new CustomerDaoImpl();
	}
	
	@Override
	public Customer addCustomer(Customer customer) throws DaoException {
		return customerDao.addCustomer(customer);
	}

	@Override
	public Customer findCustomerById(int id) throws CustomerNotFoundException {
		return customerDao.findCustomerById(id);
	}

}
