package com.javaday.clientems;

import com.javaday.clientems.controller.ClienteController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ClienteController.class})
public class ClienteMsApplication {
    // silence console logging
    @Value("${logging.level.root:OFF}")
    String message = "";

    public static void main(String[] args) {
        SpringApplication.run(ClienteMsApplication.class, args);
    }

}
