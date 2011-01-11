package com.hwsyndrome.helloworld;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hwsyndrome.helloworld.domain.Message;
import com.hwsyndrome.helloworld.service.MessageService;

public class App {

	 public static void main(String[] args) {
	        System.out.println("*** Beginning of test ***");

	        // This is where the Spring framework is "started".
	        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	        // This retreives the messageService bean, defined in the applicationContext.xml file.
	        MessageService messageService = (MessageService) context.getBean("messageService");

	        // Create a new persistent message.
	        messageService.createMessage("Hello World");
	        messageService.createMessage("HELLO JPA");
	        messageService.createMessage("I am working");

	        // Ask the service to list all messages.
	        List<Message> messages = messageService.listAllMessages();

//	        // List the messages to the system output.
	        System.out.println(messages.size() + " message(s) found");

	        for (Object m : messages) {
	            Message loadedMsg = (Message) m;
	            System.out.println(loadedMsg.getText());
	        }

	        System.out.println("*** End of test ***");
	    }


}
