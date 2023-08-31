package ru.aao.dbservice.dbservice.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aao.dbservice.dbservice.service.CardService;

@RestController
@RequiredArgsConstructor
public class CardController {

    private final CardService service;

    @GetMapping(value = "/api")
    public String getResource() {
        return service.getResource();
    }
}
