package com.kapital.sitramas.common;

import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/*
 *	@author jmatos
 *	@description Clase util para el envio de correo Electrónico 
 * 
 * */
@Component
public class EmailUtil {

	@Async
	public static void prepareEmail(String toEmail, String subject, String body){
		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		ResourceBundle rb = ResourceBundle.getBundle("com.kapital.sitramas.common.resources.mail-config");
		Enumeration <String> keys = rb.getKeys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = rb.getString(key);
			props.put(key, value);
			System.out.println(key + ": " + value);
		}
		final String fromEmail = rb.getString("mail.from.user.name");
		final String password = rb.getString("mail.from.user.password"); // correct password for gmail id 
		
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		
		Session session = Session.getDefaultInstance(props, auth);
		System.out.println("Session created");
	    EmailUtil.sendEmail(session, toEmail, subject, body);
	}
	
	
	public static void sendEmail(Session session, String toEmail, String subject, String body){
		try{
			MimeMessage msg = new MimeMessage(session);
			// set Message Headers
			msg.addHeader("Content-type","text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			
			msg.setFrom(new InternetAddress("jmatos@jmatostech.com", "Kapital Taxi - NoReply-KT"));
			msg.setReplyTo(InternetAddress.parse("no_reply@kapitaltaxi.com", false));

			msg.setSubject(subject, "UTF-8");

			//msg.setText(body, "UTF-8");
			msg.setContent(body, "text/html");

			msg.setSentDate(new Date());
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			System.out.println("Message is ready");
			Transport.send(msg);
			System.out.println("EMail Sent Successfully!!");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
