package com.example.service;

import com.example.exceptions.ItemException;
import com.example.model.Item;

import java.util.List;

public interface ItemService {
    public Item addItem(Item item) throws ItemException;
    public Item viewItem(String itemId) throws ItemException;
    public Item removeItem(String itemId) throws ItemException;

    public List<Item> sortItemByRating() throws ItemException;
    public List<Item> sortItemByPrice() throws ItemException;
}
