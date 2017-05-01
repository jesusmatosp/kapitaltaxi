package com.kapital.sitramas.common;

import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import com.kapital.sitramas.utils.ConstantesUtils;


public class SimpleEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*System.out.println("SimpleEmail Start");
		final String fromEmail = "jmatos.developer@gmail.com"; //requires valid gmail id
		final String password = "aerosmith"; // correct password for gmail id
		final String toEmail = "jesus.matosp@gmail.com"; // can be any email id 
		
		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
                //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		
		EmailUtil.sendEmail(session, toEmail,"Esta es otra Prueba", "Mira esta prueba Yius");
		*/
		String username ="jesus.matosp@gmail.com";
		String password="1234";
		String bodyMessage = "Su contraseña Se actualizó satisfactoriamente <b>Usuario: <p>"+username+
				"<br /> <b>Contrasenia:</b>"+password;
		EmailUtil.prepareEmail(username, ConstantesUtils.SUBJECT_CREDENCIALES_UPDATE , 
			bodyMessage	);
		/*final String fromEmail = "jmatos@jmatostech.com"; //requires valid gmail id
		final String password = "aerosmith"; // correct password for gmail id
		final String toEmail = "jesus.matosp@gmail.com"; // can be any email id 
		
		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "mail.jmatostech.com"); //SMTP Host
		props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		props.put("mail.smtp.port", "465"); //SMTP Port
		
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		
		Session session = Session.getDefaultInstance(props, auth);
		System.out.println("Session created");
	        EmailUtil.sendEmail(session, toEmail,"SSLEmail Testing Subject", "SSLEmail Testing Body");

	        //EmailUtil.sendAttachmentEmail(session, toEmail,"SSLEmail Testing Subject with Attachment", "SSLEmail Testing Body with Attachment");

	        //EmailUtil.sendImageEmail(session, toEmail,"SSLEmail Testing Subject with Image", "SSLEmail Testing Body with Image");

		
	/*	ResourceBundle rb = ResourceBundle.getBundle("com.kapital.sitramas.common.resources.mail-config");
		Enumeration <String> keys = rb.getKeys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = rb.getString(key);
			System.out.println(key + ": " + value);
		}
		*/
	}
}
