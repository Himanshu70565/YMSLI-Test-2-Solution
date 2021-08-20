package com.customerapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.customerapp.dao.factory.ConnectionFactory;
import com.customerapp.entities.Customer;
import com.customerapp.exceptions.CustomerNotFoundException;
import com.customerapp.exceptions.DaoException;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class CustomerDaoImpl implements CustomerDao {

	private Connection connection;

	public CustomerDaoImpl() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public Customer addCustomer(Customer customer) throws DaoException {

		String ADD_NEW_CUSTOMER = "insert into customer(name,address,phoneNumber,dob) values(?,?,?,?)";
		try {
			PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(ADD_NEW_CUSTOMER,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getAddress());
			pstmt.setString(3, customer.getPhoneNumber());
			pstmt.setDate(4, new Date(customer.getDob().getTime()));

			int noOfRowsEffected = pstmt.executeUpdate();

			if (noOfRowsEffected > 0) {
				ResultSet rs = pstmt.getGeneratedKeys();
				rs.next();
				customer.setId(rs.getInt(1));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return customer;
	}

	@Override
	public Customer findCustomerById(int id) throws CustomerNotFoundException {
		Customer customer = null;
		try {

			String FIND_CUSTOMER_BY_ID = "Select * from customer where id=?";

			PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(FIND_CUSTOMER_BY_ID);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("address"),
						rs.getString("phoneNumber"), rs.getDate("dob"));
			} else {
				throw new CustomerNotFoundException("customer not found with id : " + id);
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}

		return customer;
	}
	
}
