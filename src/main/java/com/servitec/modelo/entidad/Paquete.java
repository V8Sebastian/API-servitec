package com.servitec.modelo.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "paquete")
public class Paquete implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paquete_pk;
	@Column(length = 10)
	private String medida;
	@Column(nullable = false)
	private Long cantidadInicial;
	@Column(nullable = false)
	private Long producto_fk;
	private static final long serialVersionUID = 1L;

	@OneToOne(mappedBy = "paqueteCliente_fk")
	private PaqueteCliente paqueteCliente;

	@OneToOne(mappedBy = "paqueteProveedor_fk")
	private PaqueteProveedor paqueteProveedor;

	public Paquete() {

	}

	public Paquete(Long paquete_pk, String medida, Long cantidadInicial, Long producto_fk) {
		this.paquete_pk = paquete_pk;
		this.medida = medida;
		this.cantidadInicial = cantidadInicial;
		this.producto_fk = producto_fk;
	}

	public Long getPaquete_pk() {
		return paquete_pk;
	}

	public void setPaquete_pk(Long paquete_pk) {
		this.paquete_pk = paquete_pk;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public Long getCantidadInicial() {
		return cantidadInicial;
	}

	public void setCantidadInicial(Long cantidadInicial) {
		this.cantidadInicial = cantidadInicial;
	}

	public Long getProducto_fk() {
		return producto_fk;
	}

	public void setProducto_fk(Long producto_fk) {
		this.producto_fk = producto_fk;
	}

	public PaqueteCliente getPaqueteCliente() {
		return paqueteCliente;
	}

	public void setPaqueteCliente(PaqueteCliente paqueteCliente) {
		this.paqueteCliente = paqueteCliente;
	}

	public PaqueteProveedor getPaqueteProveedor() {
		return paqueteProveedor;
	}

	public void setPaqueteProveedor(PaqueteProveedor paqueteProveedor) {
		this.paqueteProveedor = paqueteProveedor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}