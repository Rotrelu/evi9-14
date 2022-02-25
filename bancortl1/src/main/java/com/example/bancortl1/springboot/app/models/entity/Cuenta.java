package com.example.bancortl1.springboot.app.models.entity;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table ( name = "cuentas")


public class Cuenta implements Serializable {
  private static final long serialVersionUID = 1L;


 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column
 private String nombre;

@Column
@NonNull
 private double saldo;

@Column (name = "numero_telefono")
private String numerotelefono;

@Column (name = "dia_creacion")
@NonNull
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-mm-dd")
private Date diadecracion;

    @JoinColumn(name = "banco", referencedColumnName = "id", nullable = false )
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Banco Banco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getNumerotelefono() {
		return numerotelefono;
	}

	public void setNumerotelefono(String numerotelefono) {
		this.numerotelefono = numerotelefono;
	}

	public Date getDiadecracion() {
		return diadecracion;
	}

	public void setDiadecracion(Date diadecracion) {
		this.diadecracion = diadecracion;
	}

	public Banco getBanco() {
		return Banco;
	}

	public void setBanco(Banco banco) {
		Banco = banco;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Tarjeta> getTarjeas() {
		
		return null;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		
		
	}




}
