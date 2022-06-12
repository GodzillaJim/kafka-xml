package com.github.godzillajim.kafkaxml.controllers;

import com.github.godzillajim.kafkaxml.models.ExtendedFamily;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.godzillajim.kafkaxml.services.FamilyService;

@RestController
@RequestMapping("/")
public class FamilyController {
    @Autowired
    FamilyService service;

    @GetMapping("/")
    public ResponseEntity<ExtendedFamily> publishFamily(){
        return ResponseEntity.ok(service.publishMessage());
    }
}
