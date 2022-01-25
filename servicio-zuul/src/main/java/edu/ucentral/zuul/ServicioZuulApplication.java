package edu.ucentral.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication


//habilitar zuul, configurar el gateway de eureka
@EnableZuulProxy


//activar cliente de eureka
@EnableEurekaClient
public class ServicioZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioZuulApplication.class, args);
	}

}
