package com.example.bancortl1.springboot.app.errors;

public class DataBaseBancoException  extends RuntimeException{


	private static final long serialVersionUID = 1L;
	public DataBaseBancoException() {
		super("Contacte con la administracion, se produjo un error");
	}

}
