package com.cvicse.mydemo1.service;


import com.cvicse.mydemo1.model.Card;
import com.cvicse.mydemo1.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService{

    @Autowired
    CardRepository cardRepository;

    @Override
    public Card sava(Card card) {
        if(card==null){
            return null;
        }
        return cardRepository.save(card);
    }

    @Override
    public void deleteById(Long id) {

       cardRepository.deleteById(id);
    }

    @Override
    public Card findById(Long id) {
        return cardRepository.findById(id).get();
    }

    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public Card update(Long id, Card card) {
       Card card1 = cardRepository.findById(id).get();
       card1.setId(card.getId());
       card1.setTitle(card.getTitle());
       card1.setContent(card.getContent());
       return card1;
    }
}
