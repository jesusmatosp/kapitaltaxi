package com.kapital.sitramas.seguridad.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.kapital.sitramas.be.Persona;
import com.kapital.sitramas.common.enums.EstadoEnum;

public class UsuarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7931444532363899568L;
	
	private Long idUsuario;
	private Long idPersona;
	private String comentarios;
	private Integer estado;
	private byte[] password;
	private String usuario;
	private String usuarioCreacion;
	private String usuariosModificacion;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idCliente;
	private Long idTipoUsuario;
	private List<RolDTO> roles;
	private String strpassword;
	private String strtipoUsuario;
	private String strfechaCreacion;
	private String strfechaModifica;
	private String strNombreCliente;
	private String strEstado;
	private String nombresPersona;
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public byte[] getPassword() {
		return password;
	}
	public void setPassword(byte[] password) {
		this.password = password;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	public String getUsuariosModificacion() {
		return usuariosModificacion;
	}
	public void setUsuariosModificacion(String usuariosModificacion) {
		this.usuariosModificacion = usuariosModificacion;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public Long getIdTipoUsuario() {
		return idTipoUsuario;
	}
	public void setIdTipoUsuario(Long idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	public List<RolDTO> getRoles() {
		return roles;
	}
	public void setRoles(List<RolDTO> roles) {
		this.roles = roles;
	}
	public String getStrpassword() {
		return strpassword;
	}
	public void setStrpassword(String strpassword) {
		this.strpassword = strpassword;
	}
	public String getStrtipoUsuario() {
		return strtipoUsuario;
	}
	public void setStrtipoUsuario(String strtipoUsuario) {
		this.strtipoUsuario = strtipoUsuario;
	}
	public String getStrfechaCreacion() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		strfechaCreacion = sdf.format(fechaCreacion);
		return strfechaCreacion;
	}
	public void setStrfechaCreacion(String strfechaCreacion) {
		this.strfechaCreacion = strfechaCreacion;
	}
	public String getStrfechaModifica() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		strfechaModifica = sdf.format(fechaCreacion);
		return strfechaModifica;
	}
	public void setStrfechaModifica(String strfechaModifica) {
		this.strfechaModifica = strfechaModifica;
	}
	public String getStrEstado() {
		if(estado == EstadoEnum.ACTIVO.getValue()){
			strEstado = EstadoEnum.ACTIVO.name();
		}else{
			strEstado = EstadoEnum.INACTIVO.name();
		}
		return strEstado;
	}
	public void setStrEstado(String strEstado) {
		this.strEstado = strEstado;
	}
	public String getNombresPersona() {
		return nombresPersona;
	}
	public void setNombresPersona(String nombresPersona) {
		this.nombresPersona = nombresPersona;
	}
	public String getStrNombreCliente() {
		return strNombreCliente;
	}
	public void setStrNombreCliente(String strNombreCliente) {
		this.strNombreCliente = strNombreCliente;
	}

	
}
