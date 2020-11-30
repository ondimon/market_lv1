package com.geekbrains.july.market.beans;

import com.geekbrains.july.market.entities.dtos.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@EqualsAndHashCode(of = {"product"})
public class CartItem {
    @NotNull
    private ProductDto product;
    @NotNull
    private Integer count;

    private Integer cost;

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
