package com.bancortl.springboot.app.bancortl.models.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table ( name = "cuentas")
@Getter
@Setter

public class cuenta implements Serializable {
  private static final long serialVersionUID = 1L;


 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column
 @NonNull

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

    @JoinColumn(name = "Banco", referencedColumnName = "idBanco", nullable = false )
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private cuenta Banco;




}
