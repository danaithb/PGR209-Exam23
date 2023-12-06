package com.example.pgr209exam23.controller;
//Kilde: forelesning 11
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")

//legger til dette for å legge til logging
@Slf4j
public class PartsController {

    @GetMapping()
    public String getHello(){
        return "Helloooo";
    }



}
