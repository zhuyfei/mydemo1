package com.cvicse.mydemo1.Service;

import com.cvicse.mydemo1.model.Card;
import com.cvicse.mydemo1.repository.CardRepository;
import com.cvicse.mydemo1.service.CardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardServiceTest {
    @Autowired
    CardService cardService;

    @MockBean
    CardRepository cardRepository;

    public void setUp(){

        Card card1 = new Card();
        Card card2 = new Card();
        card1.setId(1l);
        card2.setId(2l);
        card1.setTitle("一号");
        card1.setContent("一号你好");
        card2.setTitle("二号");
        card2.setContent("二号你好");

        List<Card> cardList = Arrays.asList(card1,card2);

        Mockito.when(cardRepository.findById(card1.getId())).thenReturn(Optional.of(card1));
        Mockito.when(cardRepository.findById(card2.getId())).thenReturn(Optional.of(card2));
        Mockito.when(cardRepository.findById(0l)).thenReturn(null);
        Mockito.when(cardRepository.save(new Card())).thenReturn(card2);
        Mockito.when(cardRepository.save(new Card())).thenReturn(card1);
        Mockito.when(cardRepository.findAll()).thenReturn(cardList);


    }

    @Test
    public void given2Cards_when_getAllCards_thenReturn2Records(){

        Card card1 = new Card();
        Card card2 = new Card();
        card1.setId(1l);
        card2.setId(2l);
        card1.setTitle("3号");
        card1.setContent("3号你好");
        card2.setTitle("4号");
        card2.setContent("4号你好");

        List<Card> cardList =cardService.findAll();
        assertThat(cardList).hasSize(2).extracting(Card::getContent).
                contains(card1.getContent(),card2.getContent());
    }

    @Test
    public void deleteTest(){


    }

    @Test
    public void findByIdTest(){

    }

    @Test
    public void findAllTest(){

    }

    public void update(){

    }
}
