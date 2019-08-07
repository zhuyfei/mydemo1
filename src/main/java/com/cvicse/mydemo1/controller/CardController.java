package com.cvicse.mydemo1.controller;

import com.cvicse.mydemo1.exception.CardNotFoundException;
import com.cvicse.mydemo1.model.Card;
import com.cvicse.mydemo1.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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
    public Card saveCard(@RequestBody Card card){
        return cardService.save(card);
    }

    /**
     * 根据id删除Card
     * @param id
     */
    @DeleteMapping("/api/cards/{id}")
    public void deleteCardById(@PathVariable("id")int id){
        try {
            cardService.deleteById(id);
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
     * @param id
     * @param card
     */
    @PutMapping("/api/cards/{id}")
    public Card updateCard(@PathVariable("id") int id,@RequestBody Card card){
        try {
            return cardService.update(id,card);
        }catch (CardNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not found",e);
        }

    }


}
