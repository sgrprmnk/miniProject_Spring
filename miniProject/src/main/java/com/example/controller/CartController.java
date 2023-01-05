package com.example.controller;

import com.example.exceptions.CartException;
import com.example.exceptions.ItemException;
import com.example.model.Cart;
import com.example.model.Item;
import com.example.repository.CartDao;
import com.example.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    private CartDao cartDao;

    @PostMapping("/carts")
    public ResponseEntity<Cart> saveCartController(@RequestBody Cart cart) throws CartException{
        Cart cart1=cartService.saveCart(cart);
        return new ResponseEntity<>(cart1, HttpStatus.ACCEPTED);
    }
    @PostMapping("/carts/{cartId}")
    public ResponseEntity<Cart> addItemCarthandler(@PathVariable("cartId") String cartId, @RequestBody Item item) throws ItemException, CartException {
        Cart cart=cartService.addItemToCart(cartId,item);
        return new ResponseEntity<>(cart,HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteCarts/{cartId}")
    public ResponseEntity<Cart> clearItemHandler(@PathVariable("cartId") String cartId) throws CartException {
        Cart cart=cartService.clearCart(cartId);
        return new ResponseEntity<>(cart,HttpStatus.GONE);
    }

}
