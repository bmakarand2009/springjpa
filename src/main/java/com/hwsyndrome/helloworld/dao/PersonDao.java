package com.hwsyndrome.helloworld.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.hwsyndrome.helloworld.domain.Customer;

@Repository("personDao")
public class PersonDao {

	@Autowired
	protected DataSource dataSource;
	
	private Connection connection;
	protected Connection getConn() throws Exception {
		return dataSource.getConnection();
	}
	public List<Customer> getAllCustomers(String myName) {
		String query = "SELECT * FROM person WHERE NAME like ?";
		PreparedStatement pt = null;
		List<Customer> cList = new ArrayList<Customer>();
		try {
			connection = dataSource.getConnection();
			pt = connection.prepareStatement(query);
			pt.setString(1, "%"+myName+"%");
			ResultSet rs = pt.executeQuery();
			while (rs.next()) {
				Customer c = new Customer();
				c.setName(rs.getString(2));
				c.setPhoneNumber(111);
				cList.add(c);
			}
		}catch(Exception ex) {
			System.out.println("Connection eXCEPTION");
		}
		
		return cList;
	
	}
}
