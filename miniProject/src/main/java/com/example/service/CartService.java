package com.example.service;

import com.example.exceptions.CartException;
import com.example.exceptions.ItemException;
import com.example.model.Cart;
import com.example.model.Item;

public interface CartService {
    public Cart saveCart(Cart cart) throws CartException;
    public Cart addItemToCart(String cartId, Item item) throws CartException, ItemException;
    public Cart clearCart(String cartId) throws CartException;
}
