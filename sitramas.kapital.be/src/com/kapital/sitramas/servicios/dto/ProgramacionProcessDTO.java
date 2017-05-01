package com.kapital.sitramas.servicios.dto;

import java.io.Serializable;

public class ProgramacionProcessDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String numero;
	private String sede;
	private String entradaSalida;
	private String tipo;
	private String nombres;
	private String dni;
	private String campania;
	private String departamento;
	private String responsable;
	/*private String direccion;
	private String referencia;
	private String distrito;
	private String codCobertura;
	private String horaIngreso;
	private String horaLlegada;*/
	
	public ProgramacionProcessDTO(){ }
	
	/*public ProgramacionProcessDTO(String numero, String sede, String entradaSalida, String tipo, String nombres, String dni, 
			String campania, String departamento, String responsable, String direccion, String referencia, String distrito, String codCobertura, 
			String horaIngreso, String horaLlegada){
		this.numero = numero;
		this.sede = sede;
		this.entradaSalida = entradaSalida;
		this.tipo = tipo;
		this.nombres = nombres;
		this.dni = dni;
		this.campania = campania;
		this.departamento = departamento;
		this.responsable = responsable;
		this.direccion = direccion;
		this.referencia = referencia;
		this.distrito = distrito;
		this.codCobertura = codCobertura;
		this.horaIngreso = horaIngreso;
		this.horaLlegada = horaLlegada;
	}*/
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public String getEntradaSalida() {
		return entradaSalida;
	}
	public void setEntradaSalida(String entradaSalida) {
		this.entradaSalida = entradaSalida;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCampania() {
		return campania;
	}
	public void setCampania(String campania) {
		this.campania = campania;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	/*public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getCodCobertura() {
		return codCobertura;
	}
	public void setCodCobertura(String codCobertura) {
		this.codCobertura = codCobertura;
	}
	public String getHoraIngreso() {
		return horaIngreso;
	}
	public void setHoraIngreso(String horaIngreso) {
		this.horaIngreso = horaIngreso;
	}
	public String getHoraLlegada() {
		return horaLlegada;
	}
	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	*/
}
