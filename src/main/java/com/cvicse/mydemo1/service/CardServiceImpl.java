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

    /**
     * 添加Card
     * @param card
     * @return
     */
    @Override
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    /**
     * 根据id删除Card
     * @param id
     */
    @Override
    public void deleteById(int id) {

       cardRepository.deleteById(id);
    }

    /**
     * 根据id查找Card
     * @param id
     * @return
     */
    @Override
    public Card findById(int id) {
        return cardRepository.findById(id).get();
    }

    /**
     * 查找所有Card
     * @return
     */
    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    /**
     * 更新Card
     * @param id
     * @param card
     * @return
     */
    @Override
    public Card update(int id, Card card) {
       Card card1 = cardRepository.findById(id).get();
       card1.setId(card.getId());
       card1.setTitle(card.getTitle());
       card1.setContent(card.getContent());
       cardRepository.save(card1);
       return card1;
    }
}
