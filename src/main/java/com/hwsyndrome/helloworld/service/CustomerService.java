package com.hwsyndrome.helloworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hwsyndrome.helloworld.dao.CustomerDao;
import com.hwsyndrome.helloworld.domain.Customer;
import com.hwsyndrome.helloworld.domain.Message;

@Service("customerService")
public class CustomerService {
	@Autowired
    private CustomerDao customerDao;

    //This one, put on the createMessage method overrides the default transaction definition 
    //saying that this method does require to be in a transaction 
    //(which Spring will create for you) and that it is not read only (it does write in the database).
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Customer createCustomer(Customer c) {
	 customerDao.save(c);
        return c;
    }
	
	public List<Customer>findAll(){
		return customerDao.listAll();
	}
}
