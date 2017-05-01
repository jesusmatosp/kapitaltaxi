package com.kapital.sitramas.be;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_sede database table.
 * 
 */
@Entity
@Table(name="tbl_sede")
@NamedQuery(name="Sede.findAll", query="SELECT s FROM Sede s")
public class Sede implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="n_id_sede")
	private Long id;

	@Column(name="c_cod_sede")
	private String codSede;

	@Column(name="c_nom_sede")
	private String nombreSede;

	@Column(name="c_usucrea")
	private String usuarioCreacion;

	@Column(name="c_usumod")
	private String usuarioModifica;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_feccrea")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_fecmod")
	private Date fechaModificacion;

	@Column(name="n_id_cliente")
	private Long idCliente;

	@Column(name="n_id_ubigeo")
	private Long idUbigeo;

	
	public Sede() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodSede() {
		return codSede;
	}

	public void setCodSede(String codSede) {
		this.codSede = codSede;
	}

	public String getNombreSede() {
		return nombreSede;
	}

	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioModifica() {
		return usuarioModifica;
	}

	public void setUsuarioModifica(String usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
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

	public Long getIdUbigeo() {
		return idUbigeo;
	}

	public void setIdUbigeo(Long idUbigeo) {
		this.idUbigeo = idUbigeo;
	}

}