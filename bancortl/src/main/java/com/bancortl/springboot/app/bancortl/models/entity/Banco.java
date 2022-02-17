package com.bancortl.springboot.app.bancortl.models.entity;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table (name = "bancos")

public class Banco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

 @Column
 @NonNull

 private String nombre;

 @Column
 @NonNull
    private String ubicacion;

}
