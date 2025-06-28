package br.caixa.gov.apisisra.components;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
    @PostConstruct
    public void sayHello() {
        System.out.println("### CEARA ### Hello World, from Spring Boot 3!");
    }
}
