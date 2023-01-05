package com.example.service;

import com.example.exceptions.ItemException;
import com.example.model.Item;
import com.example.repository.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemDao itemDao;

    @Override
    public Item addItem(Item item) throws ItemException {
        return itemDao.save(item);
    }

    @Override
    public Item viewItem(String itemId) throws ItemException {
        return itemDao.findById(itemId).orElseThrow(()->new ItemException("Item does not Exist"));

    }

    @Override
    public Item removeItem(String itemId) throws ItemException {
        Optional<Item> item1=itemDao.findById(itemId);
        if(item1.isPresent()){
            Item existingItem=item1.get();
            itemDao.delete(existingItem);
            return existingItem;
        } else
            throw new ItemException("Item does not exist");
    }

    @Override
    public List<Item> sortItemByRating() throws ItemException {
        return itemDao.sortBYRating();
    }

    @Override
    public List<Item> sortItemByPrice() throws ItemException {
        return itemDao.sortBYPrice();
    }
}
