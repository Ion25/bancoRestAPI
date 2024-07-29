package com.banco.bancorestapi;

import com.banco.bancorestapi.domain.entities.Cliente;
//import com.banco.bancorestapi.domain.otherDomain.valueObjects.Identificacion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BancoRestApiApplication {

	public static void main(String[] args) {
		//Cliente cliente = new Cliente( "Juan", "Dirección inventada", "987654321", "email@mail.com");

		//System.out.println(cliente.getNombre());

		SpringApplication.run(BancoRestApiApplication.class, args);
	}

	/*
	{
    "id": 1,
    "nombre": "Juan",
    "direccion": "Direccion inventada",
    "telefono": "987654321",
    "email": "email@mail.com",
    "identificacion": {
        "tipo": "DNI",
        "numero": "12345678"
    }
}

	* */

}
