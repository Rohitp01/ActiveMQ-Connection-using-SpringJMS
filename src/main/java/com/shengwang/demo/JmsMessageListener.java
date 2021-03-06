package com.shengwang.demo;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
 
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Service;
 
@Service
/**
 * Listener Implement Spring SessionAwareMessageListener Interface
 *
 */
public class JmsMessageListener implements SessionAwareMessageListener {
 
public void onMessage(Message message, Session session) throws JMSException {
	// This is the received message
	System.out.println("Hello");
	if(message instanceof TextMessage) {
		
		TextMessage tm = (TextMessage) message;
		System.out.println("Receive: "+tm.getText());
	     
	    // Let's prepare a reply message - a "ACK" String
	    ActiveMQTextMessage textMessage = new ActiveMQTextMessage();
	    textMessage.setText("ACK");
	     
	    // Message send back to the replyTo address of the income message.
	    // Like replying an email somehow. 
	    MessageProducer producer = session.createProducer(message.getJMSReplyTo());
	    producer.send(textMessage);	
		}
    }
}
