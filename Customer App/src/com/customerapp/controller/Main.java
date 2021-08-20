package com.customerapp.controller;

import java.util.Date;

import com.customerapp.entities.Customer;
import com.customerapp.service.CustomerService;
import com.customerapp.service.CustomerServiceImpl;

public class Main {
	public static void main(String[] args) {
		Customer c1=new Customer("Himanshu", "Yamunanagar", "8708081736", new Date(1999, 11, 23));
		CustomerService customerApp=new CustomerServiceImpl();
		customerApp.addCustomer(c1);
		
		customerApp.findCustomerById(1);
		
	}
}
