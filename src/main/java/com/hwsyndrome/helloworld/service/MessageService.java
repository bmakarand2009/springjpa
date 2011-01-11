package com.hwsyndrome.helloworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hwsyndrome.helloworld.dao.MessageDao;
import com.hwsyndrome.helloworld.domain.Message;

/*
Description for the @Transactional tag
This one defined a default behaviour for all the methods in the service. 
Basically, it says that those methods don't need to be part of a transaction,
but they support it. It also says that what is being done in those methods 
has no effect on the database (readOnly). Knowing this, JPA will be 
able to optimize it's work.
*/
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Service("messageService")
public class MessageService 
{

    /**
     * Used by the Spring framework to inject the MessageDao.
     */
	@Autowired
    private MessageDao messageDao;

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    /**
     * Creates and returns a persistent Message object.
     * @param text The text of the message.
     * @return The newly created (and persisted) Message object.
     */

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    //This one, put on the createMessage method overrides the default transaction definition 
    //saying that this method does require to be in a transaction 
    //(which Spring will create for you) and that it is not read only (it does write in the database).
    public Message createMessage(String text) {
        Message message = new Message(text);
        messageDao.save(message);
        return message;
    }

    /**
     * Lists all existing Message objects.
     * @return A List of Message objects.
     */
    public List<Message> listAllMessages() {
        return messageDao.listAllMessages();
    }
}