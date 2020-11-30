package com.geekbrains.july.market.beans;

import com.geekbrains.july.market.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(of = {"product"})
public class CartItem {
    private Product product;
    private int count;
    private int cost;

    public CartItem add(CartItem cartItem) {
        count += cartItem.getCount();
        cost  += cartItem.getCost();
        return this;
    }

    public CartItem remove(CartItem cartItem) {
        count -= cartItem.getCount();
        cost  -= cartItem.getCost();
        return this;
    }
}
