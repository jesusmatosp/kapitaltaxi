package com.kapital.sitramas.be;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_usuario database table.
 * 
 */
@Entity
@Table(name="tbl_usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="n_id_usuario")
	private Long id;

	@Column(name="c_comentarios")
	private String comentarios;

	@Column(name="c_estado")
	private Integer estado;

	@Lob
	@Column(name="c_password")
	private byte[] password;

	@Column(name="c_usuario")
	private String usuario;

	@Column(name="c_usucrea")
	private String usuarioCreacion;

	@Column(name="c_usumod")
	private String usuariosModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_feccrea")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_fecmod")
	private Date fechaModificacion;

	@Column(name="n_id_cliente", nullable=true)
	private Long idCliente;

	@Transient
	private String strpassword;
	
	//bi-directional many-to-one association to TipoUsuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="n_id_tipo_usuario" , insertable=false, updatable=false)
	private TipoUsuario tblTipoUsuario;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="n_id_persona", insertable=false, updatable=false)
	private Persona persona;
	

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
	
	public TipoUsuario getTblTipoUsuario() {
		return tblTipoUsuario;
	}

	public void setTblTipoUsuario(TipoUsuario tblTipoUsuario) {
		this.tblTipoUsuario = tblTipoUsuario;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Usuario() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStrpassword() {
		return strpassword;
	}

	public void setStrpassword(String strpassword) {
		this.strpassword = strpassword;
	}

	

}