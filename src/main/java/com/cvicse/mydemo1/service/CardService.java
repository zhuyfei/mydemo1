package com.cvicse.mydemo1.service;

import com.cvicse.mydemo1.model.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardService {
    Card sava(Card card);
    void deleteById(Long id);
    Card findById(Long id);
    List<Card> findAll();
    Card update(Long id,Card card2);

}
