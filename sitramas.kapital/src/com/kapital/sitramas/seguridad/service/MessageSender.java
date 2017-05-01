package com.kapital.sitramas.seguridad.service;

import com.kapital.sitramas.seguridad.dto.UsuarioDTO;

public interface MessageSender {

	public void sendMessageUsuario(UsuarioDTO user);
}
