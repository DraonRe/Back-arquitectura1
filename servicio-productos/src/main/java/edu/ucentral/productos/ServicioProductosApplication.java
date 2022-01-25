package edu.ucentral.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication

//habilitar para poder utilizar eureka
//activar eureka como cliente
@EnableEurekaClient


//agregar el common como libreria
//funcion cuando la entity no esta en el servicio
//se llama la entity de trabajo
@EntityScan({"edu.ucentral.common.productos.model"})
public class ServicioProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioProductosApplication.class, args);
	}

}
