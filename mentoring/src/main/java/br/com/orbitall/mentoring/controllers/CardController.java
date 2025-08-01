package br.com.orbitall.mentoring.controllers;

import br.com.orbitall.mentoring.canonicals.CardInput;

import br.com.orbitall.mentoring.canonicals.CardOutput;
import br.com.orbitall.mentoring.models.Card;
import br.com.orbitall.mentoring.services.CardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
  GET     /cards         pending...
  GET     /cards/{id}    pending...
  POST    /cards         ok
  PUT     /cards/{id}    pending...
  DELETE  /cards/{id}    pending...

*/
@RestController
@RequestMapping("cards")
@Slf4j
public class CardController {
    @Autowired
    private CardService service;

    @PostMapping
    public CardOutput save(@RequestBody CardInput input){
        log.info("Resquest info {}", input);

        Card card = Card.builder()
                .number(input.number())
                .cvv2(input.cvv2())
                .fullName(input.fullName())
                .validThru(input.validThru())
                .build();

        card.setNumber(input.number());
        card.setCvv2(input.cvv2());
        card.setFullName(input.fullName());
        card.setValidThru(input.validThru());


        service.create(card);



    CardOutput  output =   CardOutput.builder()
                .id(card.getId())
                .number(card.getNumber())
                .cvv2(card.getCvv2())
                .fullName(card.getFullName())
                .validThru(card.getValidThru())
                .status(card.getStatus())
                .createdAt(card.getCreatedAt())
                .updatedAt(card.getUpdatedAt())
                .build();

        log.info("Response info {}", output);

        return output;
    }

}
