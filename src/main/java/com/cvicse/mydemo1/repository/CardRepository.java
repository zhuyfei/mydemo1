package com.cvicse.mydemo1.repository;

import com.cvicse.mydemo1.model.Card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends CrudRepository<Card,Integer> {
    Card save(Card card);
    void deleteById(Integer id);
    List<Card> findAll();
    void deleteAll();
    Optional<Card> findById(Integer id);

}
