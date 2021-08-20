package com.customerapp.dao;

import java.util.*;
import com.customerapp.entities.*;
import com.customerapp.exceptions.*;

public interface CustomerDao {
	
	public Customer addCustomer(Customer customer) throws DaoException;

	public Customer findCustomerById(int id) throws CustomerNotFoundException;

}
