package com.media.tecnm.market_backend_v2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludo")
public class HelloWorldController {

    @GetMapping("/hola")
    public String saludar() {
        return "¡Hola Mundo desde Spring Boot!";
    }
}