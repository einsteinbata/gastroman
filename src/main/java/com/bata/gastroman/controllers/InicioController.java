package com.bata.gastroman.controllers;

import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/inicio")
public class InicioController {

    @GetMapping("/ola")
    public ResponseEntity<String> cumprimentar(){
        return ResponseEntity.ok("Eis a resposta desejada.");
    }

    @GetMapping("/ola/{nome}")
    public ResponseEntity<String> cumprimentar(@PathVariable String nome){
        return ResponseEntity.ok("Eis a sua resposta lord, " + nome + ".");
    }

    @GetMapping("/ola/")
    public ResponseEntity<String> greet(@PathParam(value = "nome") String nome, @PathParam(value = "apelido") String apelido){
        return ResponseEntity.ok(
                "Esta aqui é a sua resposta, " +
                        nome +
                        " " +
                        apelido +
                        "!"
        );
    }
}
