package com.hwsyndrome.helloworld.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.hwsyndrome.helloworld.domain.Customer;
import com.hwsyndrome.helloworld.domain.Message;

@Repository("customerDao")
public class CustomerDao {
   @PersistenceContext
    private EntityManager entityManager;

   /**
    * Used by the Spring framework to inject the EntityManager.
    * @param entityManager
    */
   public void setEntityManager(EntityManager entityManager) {
       this.entityManager = entityManager;
   }

   /**
    * Lists all the messages contained in the database.
    * @return A List collection of all the Messages objects.
    */
   public List<Customer> listAll() {
       return entityManager.createQuery("select m from Customer m")
               .getResultList();
   }

   /**
    * Saves a Message object into the database.
    * @param message The message object to persist.
    */
   public void save(Customer customer) {   	
       entityManager.persist(customer);
       
   }
}
