package com.hwsyndrome.helloworld.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A message representation in our Hello World example.
 */
@Entity
@Table(name = "t_messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "message_id", nullable = false)
    private Long id;
    
    @Column(name = "message_text")
    private String text;

    /**
     * The default constructor (this is required and we need to define it since
     * we also define another constructor).
     */
    public Message() {
    }

    /**
     * Constructor that takes the message as a String parameter.
     * @param text
     */
    public Message(String text) {
        this.text = text;
    }

    /**
     * Retreives the unique identifier of the message (note that there is no
     * setter because the id is managed by JPA).
     * @return The Message object's id as a Long.
     */
    public Long getId() {
        return id;
    }

    /**
     * Retreives the text of the message.
     * @return The Message object's text as a String.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text of the message.
     * @param text The Message object's text as a String.
     */
    public void setText(String text) {
        this.text = text;
    }
}