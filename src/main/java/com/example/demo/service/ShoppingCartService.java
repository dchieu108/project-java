package com.example.demo.service;

import com.example.demo.entity.CartItem;

import java.util.Collection;

public interface ShoppingCartService {
    void add(CartItem item);

    void remove(int id);

    CartItem updatee(int proID, int qty);

    void clear();

    Collection<CartItem> getAllItems();

    int getCount();

    double getTotal();


}
