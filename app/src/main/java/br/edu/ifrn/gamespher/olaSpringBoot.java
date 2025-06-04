package br.edu.br.ifrn.gamespher;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class olaSpringBoot {
    
   @GetMapping("\")
   public String index() {
       return "Olá Spring Boot!";
   }


}
