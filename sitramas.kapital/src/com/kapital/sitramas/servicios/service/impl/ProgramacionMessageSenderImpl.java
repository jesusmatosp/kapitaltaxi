package com.kapital.sitramas.servicios.service.impl;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import org.springframework.stereotype.Service;

import com.kapital.sitramas.servicios.dto.ProcesoProgramacionDTO;
import com.kapital.sitramas.servicios.service.ProgramacionMessageSender;

@Service
public class ProgramacionMessageSenderImpl implements ProgramacionMessageSender{

	@Resource(mappedName="jms/KapitalConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	@Resource(mappedName="jms/KapitalProcessQueue")
	private Queue queue;
	
	@Override
	public void sendProgramacionMessage(String file, Long idProgramacion, Long idCargaMasiva) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Session session = null;
		try{
			conn = connectionFactory.createConnection();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer productor = session.createProducer(queue);
			ObjectMessage object = session.createObjectMessage(new ProcesoProgramacionDTO(file, idProgramacion, idCargaMasiva));
			productor.send(object);
		}catch(JMSException e){
			e.printStackTrace();
		}finally {
			try{
				if(session != null){
					session.close();
				}
				if(conn != null){
					conn.close();
				}
			}catch(JMSException e){ }
		}
		
	}

}
