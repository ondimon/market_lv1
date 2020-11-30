package com.geekbrains.july.market.controllers.rest;

import com.geekbrains.july.market.beans.Cart;
import com.geekbrains.july.market.beans.CartItem;
import com.geekbrains.july.market.entities.Product;
import com.geekbrains.july.market.entities.mappers.ProductMapper;
import com.geekbrains.july.market.exceptions.ProductNotFoundException;
import com.geekbrains.july.market.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/cart")
public class CartsController {

    private Cart cart;
    private ProductsService productsService;

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(cart.getProducts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveCartProduct(@Validated @RequestBody CartItem cartItem) {
        cart.addProduct(getCartItemForCart(cartItem));
        return new ResponseEntity<>(cart.getProducts(), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCartProduct(@Validated @RequestBody CartItem cartItem) {
        cart.deleteProduct(getCartItemForCart(cartItem));
        return new ResponseEntity<>(cart.getProducts(), HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleException(ProductNotFoundException exc) {
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleException(MethodArgumentNotValidException exc) {
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
    }

    private CartItem getCartItemForCart(CartItem cartItem) {
        Product product = productsService.findById(cartItem.getProduct().getId());
        int count = cartItem.getCount();
        return  new CartItem(ProductMapper.MAPPER.fromProduct(product),
                            count,
                        count * product.getPrice());
    }

}
