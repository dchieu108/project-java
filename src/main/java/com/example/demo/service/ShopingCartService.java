package com.example.demo.service;

import com.example.demo.entity.CartItem;
import com.example.demo.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@SessionScope
public class ShopingCartService implements ShoppingCartService{
    Map<Integer, CartItem> maps = new HashMap<>();//gio hang
    @Override
    public void add(CartItem item){
        CartItem cartItem =maps.get(item.getProductId());
        if (cartItem == null){
            maps.put(item.getProductId(),item);
        }else {
            cartItem.setQty(cartItem.getQty()+1);
        }
    }

    @Override
    public void remove(int id){
        maps.remove(id);
    }
    @Override
    public CartItem updatee (int proID,int qty){
        CartItem cartItem =maps.get(proID);
        cartItem.setQty(qty);
        return cartItem;
    }
    @Override
    public void clear(){
        maps.clear();
    }
    @Override
    public Collection<CartItem> getAllItems(){
        return maps.values();
    }
    @Override
    public int getCount(){
        return maps.values().size();
    }
    @Override
    public double getTotal(){
        return maps.values().stream()
                .mapToDouble(item ->item.getQty()* item.getPrice())
                .sum();
    }
}
