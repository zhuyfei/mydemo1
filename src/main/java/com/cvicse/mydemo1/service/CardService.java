package com.cvicse.mydemo1.service;

import com.cvicse.mydemo1.model.Card;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CardService {
    Card save(Card card);//添加Card
    void deleteById(int id);//根据id删除Card
    Card findById(int id);//根据id查找Card
    List<Card> findAll();//查找所有Card
    Card update(Card card2);//更新Card

}
