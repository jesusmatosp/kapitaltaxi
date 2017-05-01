package com.kapital.sitramas.seguridad.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.kapital.sitramas.common.enums.EstadoCivilEnum;
import com.kapital.sitramas.common.enums.EstadoEnum;
import com.kapital.sitramas.common.enums.SexoEnum;
import com.kapital.sitramas.common.enums.TipoDocumentoEnum;

public class PersonaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String apellidoMaterno;
	private String apellidoPaterno;
	private String correoElectronico;
	private String direccion;
	private String dni;
	private String estado;
	private String estadoCivil;
	private String nombres;
	private String celular1;
	private String celular2;
	private String rutaFoto;
	private String sexo;
	private String fijo;
	private String tipoDocumento;
	private String usuarioCreacion;
	private String usuarioModificacion;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date fechaNacimiento;
	private Long idUbigeo;
	private UsuarioDTO usuario;
	private String strfechaNacimiento;
	private String strNombresCompletos;
	private String strSexo;
	private String strEstadoCivil;
	private String strEstado;
	private String strFechaCreacion;
	private String comentarios;
	//
	private String strDepartamento;
	private String strProvincia;
	private String strDistrito;
	private String strTipoDocumento;
	
	public PersonaDTO(){
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getCelular1() {
		return celular1;
	}
	public void setCelular1(String celular1) {
		this.celular1 = celular1;
	}
	public String getCelular2() {
		return celular2;
	}
	public void setCelular2(String celular2) {
		this.celular2 = celular2;
	}
	public String getRutaFoto() {
		return rutaFoto;
	}
	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getFijo() {
		return fijo;
	}
	public void setFijo(String fijo) {
		this.fijo = fijo;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
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
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Long getIdUbigeo() {
		return idUbigeo;
	}
	public void setIdUbigeo(Long idUbigeo) {
		this.idUbigeo = idUbigeo;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public String getStrfechaNacimiento() {
		if(fechaNacimiento != null){
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			strfechaNacimiento = sdf.format(fechaNacimiento);
		}
		return strfechaNacimiento;
	}

	public void setStrfechaNacimiento(String strfechaNacimiento) {
		this.strfechaNacimiento = strfechaNacimiento;
	}

	public String getStrNombresCompletos() {
		strNombresCompletos = nombres + " " + apellidoPaterno + " " + apellidoMaterno;
		return strNombresCompletos;
	}

	public void setStrNombresCompletos(String strNombresCompletos) {
		this.strNombresCompletos = strNombresCompletos;
	}

	public String getStrSexo() {
		strSexo = SexoEnum.get(sexo).name();
		return strSexo;
	}

	public void setStrSexo(String strSexo) {
		this.strSexo = strSexo;
	}

	public String getStrEstadoCivil() {
		strEstadoCivil = EstadoCivilEnum.get(Integer.parseInt(estadoCivil)).name();
		return strEstadoCivil;
	}

	public void setStrEstadoCivil(String strEstadoCivil) {
		this.strEstadoCivil = strEstadoCivil;
	}

	public String getStrEstado() {
		if(Integer.parseInt(estado) == EstadoEnum.ACTIVO.getValue()){
			strEstado = EstadoEnum.ACTIVO.name();
		}else{
			strEstado = EstadoEnum.INACTIVO.name();
		}
		return strEstado;
	}

	public void setStrEstado(String strEstado) {
		this.strEstado = strEstado;
	}

	public String getStrFechaCreacion() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		strFechaCreacion = sdf.format(fechaCreacion);
		return strFechaCreacion;
	}

	public void setStrFechaCreacion(String strFechaCreacion) {
		this.strFechaCreacion = strFechaCreacion;
	}

	public String getStrDepartamento() {
		return strDepartamento;
	}

	public void setStrDepartamento(String strDepartamento) {
		this.strDepartamento = strDepartamento;
	}

	public String getStrProvincia() {
		return strProvincia;
	}

	public void setStrProvincia(String strProvincia) {
		this.strProvincia = strProvincia;
	}

	public String getStrDistrito() {
		return strDistrito;
	}

	public void setStrDistrito(String strDistrito) {
		this.strDistrito = strDistrito;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getStrTipoDocumento() {
		if(tipoDocumento != null)
			strTipoDocumento = TipoDocumentoEnum.get(Integer.parseInt(tipoDocumento)).name();
		return strTipoDocumento;
	}

	public void setStrTipoDocumento(String strTipoDocumento) {
		this.strTipoDocumento = strTipoDocumento;
	}

	
	
}
