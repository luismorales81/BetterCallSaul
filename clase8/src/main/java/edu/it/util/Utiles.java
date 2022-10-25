package edu.it.util;

import java.util.UUID;

import com.github.javafaker.Faker;

import edu.it.dtos.Alumno;

public class Utiles {
	private static Faker fkr;
	static {
		fkr = new Faker();
	}
	public static Alumno crearAlumnoRandom() {
		var usu = Alumno.builder()
        		.id(UUID.randomUUID().toString())
        		.nombre(fkr.address().firstName())
        		.apellido(fkr.address().lastName())
        		.calle(fkr.address().streetName())
        		.calleNumero(fkr.address().streetAddressNumber())
        		.estado(fkr.address().state())
        		.pais(fkr.address().country())
        		.build();
        
        return usu;
	}
}
