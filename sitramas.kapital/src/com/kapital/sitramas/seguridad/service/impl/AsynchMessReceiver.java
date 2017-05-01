package com.kapital.sitramas.seguridad.service.impl;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;

import org.springframework.stereotype.Component;

@Component
public class AsynchMessReceiver{
	
	@Resource(mappedName="jms/KapitalConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	@Resource(mappedName="jms/KapitalQueue")
	private Queue queue;
	
	public void getMessages(){
		Connection con = null;
		MessageConsumer consumidor = null ;
		Session session = null;
		try{
			 System.out.println("Dentro del Consumidor....");
			 con = connectionFactory.createConnection();
			 session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			 consumidor = session.createConsumer(queue);
			 System.out.println("Recuperamos al consumidor....");
			 consumidor.setMessageListener(new ExampleMessageListener());
			 System.out.println("Iniciando Proceso....");
			 con.start();
			 Thread.sleep(8000);
			 /*consumidor.close();
			 session.close();
			 con.close();*/
		}catch(JMSException e){
			e.printStackTrace();
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try{
				if(session != null){
					session.close();
				}
				if(con != null){
					con.close();
				}
			}catch(JMSException e){e.printStackTrace();}
		}
		
	}

}
