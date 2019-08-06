package com.cvicse.mydemo1.Service;

import com.cvicse.mydemo1.model.Card;
import com.cvicse.mydemo1.repository.CardRepository;
import com.cvicse.mydemo1.service.CardService;
import com.cvicse.mydemo1.service.CardServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardServiceTest {
    @TestConfiguration
    static class CardServiceImplTestContextConfiguration {

        @Bean
        public CardService cardService () {
            return new CardServiceImpl();
        }
    }

    @Autowired
    CardService cardService;

    @MockBean
    CardRepository cardRepository;

    private Card newCard;

    @Before
    public void setUp() {

        Card card = new Card("测试");
        card.setId(1);
        Card card1 = new Card("测试2");
        card1.setId(2);

        newCard = new Card("测试2");
        List<Card> allCards = Arrays.asList(card,card1);
        Mockito.when(cardRepository.findById(card.getId())).thenReturn(Optional.of(card));

//        Mockito.when(cardRepository.deleteAll()).thenReturn(null);
        Mockito.when(cardRepository.save(newCard)).thenReturn(card1);
        Mockito.when(cardRepository.findAll()).thenReturn(allCards);
        Mockito.when(cardRepository.save(card)).thenReturn(card);
    }

    @Test
    public void findAllTest(){

        Card card = new Card("测试");
        card.setId(1);
        Card card2 = new Card("测试2");
        card2.setId(2);
        List<Card> allCards = cardService.findAll();

        assertThat(allCards).hasSize(2).extracting(Card::getContent).
                contains(card.getContent(),card2.getContent());

    }

    @Test
    public void updateTest(){

        Card card1 = new Card("测试2");
        Card card = cardService.update(1,card1);
        assertThat(card).extracting("content").
                contains("测试2");
    }

//    @Test
//    public void deleteByIdTest(){
//
//        Card card2 = new Card("测试2");
//        cardService.update(2,card2);
//    }

    @Test
    public void findByIdTest(){
        Card card = new Card("测试");
        card.setId(1);
        Card card1 = cardService.findById(card.getId());
        assertThat(card1).extracting("content").
                contains("测试");
    }

    @Test
    public void saveTest(){

        Card card1 = cardService.save(newCard);
        assertThat(card1).extracting("content").
                contains("测试2");
    }
}
