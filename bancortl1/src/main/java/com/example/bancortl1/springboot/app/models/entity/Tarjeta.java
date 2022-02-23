package com.example.bancortl1.springboot.app.models.entity;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tarjetas")
public class Tarjeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long Id;



@Column (name = "numero_tarjeta", nullable = false, length = 16)
@NotEmpty
    private String numeroTarjeta;

@Column (name = "icv", nullable = false,length = 3)
@NotEmpty
private String ivc;

@Column(name = "vencimiento")
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-mm-dd")
private Date vencimieto;

@JoinColumn(name = "cuenta", referencedColumnName = "id", nullable = false )
@ManyToOne(optional = false,fetch = FetchType.LAZY)
private Cuenta cuenta;

public Long getId() {
	return Id;
}

public void setId(Long id) {
	Id = id;
}

public String getNumroTarjeta() {
	return numeroTarjeta;
}

public void setNumroTarjeta(String numeroTarjeta) {
	this.numeroTarjeta = numeroTarjeta;
}

public String getIvc() {
	return ivc;
}

public void setIvc(String ivc) {
	this.ivc = ivc;
}

public Date getVencimieto() {
	return vencimieto;
}

public void setVencimieto(Date vencimieto) {
	this.vencimieto = vencimieto;
}

public Cuenta getCuenta() {
	return cuenta;
}

public void setCuenta(Cuenta cuenta) {
	this.cuenta = cuenta;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}


}
