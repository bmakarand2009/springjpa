package com.hwsyndrome.helloworld;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hwsyndrome.helloworld.domain.Customer;
import com.hwsyndrome.helloworld.domain.Message;
import com.hwsyndrome.helloworld.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;


public class App {

	 public static void main(String[] args) {
	        System.out.println("*** Beginning of test ***");
	        new App().init();
	  }

	CustomerService customerService;
	final Logger logger = LoggerFactory.getLogger(App.class);

	private void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        customerService = (CustomerService) context.getBean("customerService");
        List<Customer> customerList = createAndGetCustomers();

	}
	private  List<Customer> createAndGetCustomers() {
		
		Customer c1 = new Customer();
		c1.setName("cusotmer1");
		c1.setPhoneNumber(111);
		customerService.createCustomer(c1);
		
		Customer c2 = new Customer();
		c2.setName("cusotmer2");
		c2.setPhoneNumber(222);
		customerService.createCustomer(c2);

		Customer c3 = new Customer();
		c3.setName("cusotmer3");
		c3.setPhoneNumber(333);
		
		customerService.createCustomer(c3);

		List<Customer> cList = customerService.findAll();
		System.out.println(cList.size() + " customers(s) found");
		return cList;
	}

	
}
