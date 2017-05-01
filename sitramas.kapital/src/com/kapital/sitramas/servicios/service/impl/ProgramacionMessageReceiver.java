package com.kapital.sitramas.servicios.service.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ProgramacionMessageReceiver {

	@Resource(mappedName="jms/KapitalConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	@Resource(mappedName="jms/KapitalProcessQueue")
	private Queue queue;
	
	/*@Autowired
	private JobLauncher JobLauncher;
	@Autowired
	private Job programacionJob;*/ 
	
	@Autowired
	private ProgramacionMessageListener programacionMessageListener;
	
	public void procesarCargaMasiva(){
		Connection conn = null;
		Session session = null;
		try{
			conn = connectionFactory.createConnection();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageConsumer consumidor = session.createConsumer(queue);
			Logger.getLogger(getClass().getName()).log(Level.INFO, "[SITRAMAS]", "Inicia Consumidor...");
			//consumidor.setMessageListener(new ProgramacionMessageListener(JobLauncher, programacionJob));
			consumidor.setMessageListener(programacionMessageListener);
			conn.start();
			Thread.sleep(20000);
		}catch(JMSException e){
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR Cola:", e);
			e.printStackTrace();
		}catch (InterruptedException e) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR Thread:", e);
			e.printStackTrace();
		}finally {
			try{
				if(session != null){
					session.close();
				}
				if(conn != null){
					conn.close();
				}
			}catch(JMSException e){e.printStackTrace();}
		}
	}
}
