package com.example.service;

import com.example.exceptions.CartException;
import com.example.exceptions.ItemException;
import com.example.model.Cart;
import com.example.model.Item;
import com.example.repository.CartDao;
import com.example.repository.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
   private CartDao cartDao;
    @Autowired
    ItemDao itemDao;

    @Override
    public Cart saveCart(Cart cart) throws CartException {
        return cartDao.save(cart);
    }

    @Override
    public Cart addItemToCart(String cartId, Item item) throws CartException, ItemException {
        Optional<Cart>optional=cartDao.findById(cartId);
        if(optional.isPresent()){
            Cart cart=optional.get();
            cart.getItemList().add(item);
            return cartDao.save(cart);
        } else{
            throw new CartException("Cart is not found");
        }
    }

    @Override
    public Cart clearCart(String cartId) throws CartException {
        Optional<Cart> optional =cartDao.findById(cartId);
        if(optional.isPresent()){
            Cart cart =optional.get();
            cartDao.delete(cart);
            return cart;
        } else{
            throw new CartException("Cart not clear...");
        }
    }
}
