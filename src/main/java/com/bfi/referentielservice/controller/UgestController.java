package com.bfi.referentielservice.controller;

import com.bfi.referentielservice.entities.Ugest;
import com.bfi.referentielservice.services.UgestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UgestController {
    @Autowired
    UgestService ugestService;

    @PostMapping("/saveAgence")
    public Ugest saveAgence (@RequestBody Ugest agence) {
        return ugestService.saveAgence(agence);
    }




}
