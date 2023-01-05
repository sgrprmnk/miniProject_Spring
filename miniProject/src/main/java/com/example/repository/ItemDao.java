package com.example.repository;

import com.example.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemDao extends JpaRepository<Item,String> {
    @Query("select s from Item s order by s.rating desc")
    public List<Item> sortBYRating();

    @Query("select s from Item s order by s.price desc")
    public List<Item> sortBYPrice();
}
