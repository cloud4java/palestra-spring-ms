package com.javaday.pedidoms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PedidoMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidoMsApplication.class, args);
	}

}
