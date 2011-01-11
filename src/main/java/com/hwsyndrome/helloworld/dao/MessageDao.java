package com.hwsyndrome.helloworld.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.hwsyndrome.helloworld.domain.Message;

/**
 * Data Access Object (DAO) for the Message class.
 */
@Repository("messageDao")
public class MessageDao {
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
    public List<Message> listAllMessages() {
        return entityManager.createQuery("select m from Message m order by m.text asc")
                .getResultList();
    }

    /**
     * Saves a Message object into the database.
     * @param message The message object to persist.
     */
    public void save(Message message) {
    	
        entityManager.persist(message);
        
    }

    /**
     * Updates a persistent message object in the database.
     * @param message The modified message object.
     * @return A new reference to the object (might be different from the one passed).
     */
    public Message update(Message message) {
        return entityManager.merge(message);
    }

    /**
     * Deletes an object's entry from the database.
     * @param message The message to delete.
     */
    public void delete(Message message) {
        entityManager.remove(message);
    }
}
