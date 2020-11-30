package com.geekbrains.july.market.beans;

import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@EqualsAndHashCode(of = {"id"})
@Component
//@Scope("prototype")
@SessionScope
public class Cart implements Serializable {
    private Long id;
    private final List<CartItem> products = new ArrayList<>();

    public List<CartItem> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addProduct(CartItem cartItem) {
       CartItem findCartItem = findCartItem(cartItem);
       if(findCartItem == null) {
           products.add(cartItem);
       } else {
           findCartItem.add(cartItem);
       }
    }

    public void deleteProduct(CartItem cartItem) {
        CartItem findCartItem = findCartItem(cartItem);
        if(findCartItem == null) {
            return;
        }
        findCartItem.remove(cartItem);
        if( findCartItem.getCount() <= 0) {
            products.remove(findCartItem);
        }

    }

    private CartItem findCartItem(CartItem cartItem) {
        int index = products.indexOf(cartItem);
        if (index == -1) {
            return null;
        } else {
            return products.get(index);
        }
    }


}
