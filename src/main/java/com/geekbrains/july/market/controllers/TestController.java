package com.geekbrains.july.market.controllers;

import com.geekbrains.july.market.beans.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private Test test;

    @GetMapping
    public ResponseEntity<?> getTest() {
        test.setCount(test.getCount() + 1);
        return new ResponseEntity<>(test, HttpStatus.OK);
    }

}
