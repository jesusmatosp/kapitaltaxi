package com.kapital.sitramas.seguridad.service.impl;

import org.springframework.stereotype.Component;

import com.kapital.sitramas.seguridad.dto.UsuarioDTO;

@Component
public class MessageAlertHandler {

	public void handleMessageAlert(UsuarioDTO user){
		System.out.println("Usuario: "+user.getUsuario());
	}
}
