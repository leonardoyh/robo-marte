package com.robo.controller;

import com.robo.service.RoboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class RoboController {

    private RoboService service;

    @Autowired
    public RoboController(RoboService service) {
        this.service = service;
    }

    @PostMapping("/mars/{comandos}")
    public ResponseEntity<String> createCustomer(@PathVariable String comandos) {
        return ResponseEntity.ok(service.posicaoFinalAposComandos(comandos));
    }

}
