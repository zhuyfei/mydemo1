package com.cvicse.mydemo1.model;

import com.cvicse.mydemo1.repository.CardRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CardRepositoryTest {

    @Autowired
    private CardRepository cardRepository;
    Card card1,card2;
    @Before
    public void setUp(){
        this.cardRepository.deleteAll();
        card1 = new Card();
        card1.setTitle("你好啊");
        card1.setContent("你好啊");
        card2 = new Card();
        card2.setTitle("你好");
        card2.setContent("你好");
        cardRepository.save(card1);
        cardRepository.save(card2);
    }

    @Test
    public void savaTest(){
        Card card = new Card();
        card.setTitle("你好a");
        card.setContent("nihaoa");

        Card card1 = new Card();
        card1.setTitle("你好aa");
        card1.setContent("nihaoaa");
//        entityManager.persist(card);
//        entityManager.flush();

        cardRepository.save(card);
        cardRepository.save(card1);

        Iterable iterable = cardRepository.findAll();
        Iterator iterator = iterable.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void findByIdTest(){
        Card card = new Card();
        card.setId(1l);
        card.setTitle("你好a");
        card.setContent("nihaoa");

        Card card1 = new Card();
        card.setId(28l);
        card1.setTitle("你好aa");
        card1.setContent("nihaoaa");

        cardRepository.save(card);
        cardRepository.save(card1);

        System.out.println(cardRepository.findById(1l));
    }

    @Test
    public void findAllText() {

//        Card card = new Card();
//        card.setTitle("你好a");
//        card.setContent("nihaoa");
//
//        Card card1 = new Card();
//        card1.setTitle("你好aa");
//        card1.setContent("nihaoaa");

//        cardRepository.save(card);
//        cardRepository.save(card1);
//        entityManager.persist(card);
//        entityManager.flush();
//        entityManager.persist(card1);
//        entityManager.flush();

        Iterable iterable = cardRepository.findAll();
        Iterator iterator = iterable.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void deleteByIdTest(){
        Card card = new Card();
        card.setTitle("你好a");
        card.setContent("nihaoa");

        Card card1 = new Card();
        card1.setTitle("你好aa");
        card1.setContent("nihaoaa");

        cardRepository.save(card);
        cardRepository.save(card1);

        cardRepository.deleteById(card.getId());

        Iterable iterable = cardRepository.findAll();
        Iterator iterator = iterable.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public  void updateText(){
        Card card = new Card();
        card.setId(1l);
        card.setTitle("你");
        card.setContent("ni");
        cardRepository.save(card);
        card = new Card();
        card.setId(1l);
        card.setTitle("啊");
        card.setContent("啊");
        cardRepository.save(card);
        Iterable iterable = cardRepository.findAll();
        Iterator iterator = iterable.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
