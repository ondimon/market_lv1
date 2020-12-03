package com.geekbrains.july.market.controllers;

import com.geekbrains.july.market.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class AdditionalController {
    private UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/userinfo")
    public String getUserInfo(Model model, Principal principal) {
        model.addAttribute("user", usersService.findByUsername(principal.getName()));
        return "user_info";
    }
}