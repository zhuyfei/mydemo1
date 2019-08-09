package com.cvicse.mydemo1.controller;

import com.cvicse.mydemo1.exception.CardNotFoundException;
import com.cvicse.mydemo1.model.Card;
import com.cvicse.mydemo1.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController

public class CardController {

    @Autowired
    private CardService cardService;

    /**
     * 保存Card
     * @param card
     * @return
     */
    @PostMapping("/api/card")
    public List<Card> saveCard(@RequestBody Card card) {
//        List<Card> list = new ArrayList() ;
        cardService.save(card);
        return cardService.findAll();
        }


    /**
     * 根据id删除Card
     * @param id
     */
    @DeleteMapping("/api/cards/{id}")
    public List<Card> deleteCardById(@PathVariable("id")int id){
        try {
            cardService.deleteById(id);
            return cardService.findAll();
        } catch (CardNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not found",e);
        }
    }

    /**
     * 根据id查找Card
     * @param id
     * @return
     */
    @GetMapping("/api/cards/{id}")
    public Card findCardById(@PathVariable("id") int id){
        try {
            return cardService.findById(id);
        }catch (CardNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not found",e);
        }

    }

    /**
     * 查找所有Card
     * @return
     */
    @GetMapping("/api/cards")
    public List<Card> findAllCard(){
        return cardService.findAll();
    }

    /**
     * 更新Card
     * @param card
     */
    @PutMapping("/api/cards")
    public List<Card> updateCard(@RequestBody Card card){
        try {
             cardService.update(card);
            return cardService.findAll();
        }catch (CardNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not found",e);
        }

    }


}
