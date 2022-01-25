package edu.ucentral.servicio.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
@EntityScan({"edu.ucentral.common.vendedores.model"})
public class ServicioVendedoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioVendedoresApplication.class, args);
	}

}
