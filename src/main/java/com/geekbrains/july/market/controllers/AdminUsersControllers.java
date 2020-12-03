package com.geekbrains.july.market.controllers;

import com.geekbrains.july.market.entities.User;
import com.geekbrains.july.market.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/users")
public class AdminUsersControllers {
    private UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("users", usersService.findAllUsers());
        return "all_users";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("user", usersService.findById(id));
        return "edit_user";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute User user) {
        User userOld = usersService.findById(user.getId());
        user.setPassword(userOld.getPassword());
        usersService.saveOrUpdate(user);
        return "redirect:/admin/users";
    }

}
