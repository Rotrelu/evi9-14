package com.bancortl.springboot.app.bancortl.models.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tarjetas")
public class Tarjeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;



@Column (name = "numero_tarjeta", nullable = false, length = 16)
    private String numroTarjeta;

@Column (name = "icv", nullable = false,length = 3)

private String ivc;

@Column(name = "vencimiento")
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-mm-dd")
private Date vencimieto;

@JoinColumn(name = "cuenta", referencedColumnName = "id", nullable = false )
@ManyToOne(optional = false,fetch = FetchType.LAZY)
private cuenta cuenta;


}
