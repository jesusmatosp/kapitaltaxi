package com.kapital.sitramas.seguridad.service.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import com.kapital.sitramas.common.EmailUtil;
import com.kapital.sitramas.seguridad.dto.UsuarioDTO;
import com.kapital.sitramas.utils.ConstantesUtils;

public class ExampleMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Dento del cuerpo de mensajes....");
		try{
			ObjectMessage user = (ObjectMessage) message;
	        System.out.println("Objeto: "+user.getObject());
	        System.out.println("Objeto: "+((UsuarioDTO) user.getObject()).getUsuario());
	        UsuarioDTO usuarioDTO = (UsuarioDTO) user.getObject();
	        
	        if(((UsuarioDTO) user.getObject()).getUsuario() != null || ((UsuarioDTO) user.getObject()).getUsuario().length() > 0 ){
	        	String bodyMessage = "Su contraseña Se actualizó satisfactoriamente <strong>Usuario: </strong>"+((UsuarioDTO) user.getObject()).getUsuario()+
						"<br /><strong>Contrasenia:</strong>"+((UsuarioDTO) user.getObject()).getStrpassword();
				EmailUtil.prepareEmail(usuarioDTO.getUsuario(), ConstantesUtils.SUBJECT_CREDENCIALES_UPDATE , 
					bodyMessage	);	
	        }
		}catch(JMSException e){
			e.printStackTrace();
		}
	}

}
