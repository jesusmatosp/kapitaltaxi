package com.kapital.sitramas.seguridad.service.impl;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import org.springframework.stereotype.Service;

import com.kapital.sitramas.seguridad.dto.UsuarioDTO;
import com.kapital.sitramas.seguridad.service.MessageSender;

@Service
public class MessageSenderImpl implements MessageSender {

	@Resource(mappedName="jms/KapitalConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	@Resource(mappedName="jms/KapitalQueue")
	private Queue queue;
	
	
	@Override
	public void sendMessageUsuario(UsuarioDTO user) {
		Connection con = null;
		Session session = null;
		try{
			con = connectionFactory.createConnection();
			session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer productor = session.createProducer(queue);
			ObjectMessage object = session.createObjectMessage(user);
			productor.send(object);
		}catch(JMSException e){
			e.printStackTrace();
		}finally {
			try{
				if(session != null){
					session.close();
				}
				if(con != null){
					con.close();
				}
			}catch(JMSException e){ }
		}
	}	
}
