package com.cvicse.mydemo1.controller;

import com.cvicse.mydemo1.model.Card;
import com.cvicse.mydemo1.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        cardService.deleteById(id);
    }

    /**
     * 根据id查找Card
     * @param id
     * @return
     */
    @GetMapping("/api/cards/{id}")
    public Card findCardById(@PathVariable("id") int id){
        return cardService.findById(id);
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
        return cardService.update(id,card);
    }


}
