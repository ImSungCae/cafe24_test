package com.demo.controller;

import com.demo.model.User;
import com.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class Maincontroller {

    private UserRepo userRepo;

    @Autowired
    public Maincontroller(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("")
    public String welcomePage(Model model) {
        User user = new User();
        user.setUid("Hello");
        user.setPw("World");
        userRepo.save(user);
        List<User> userList = userRepo.findAll();
        model.addAttribute(userList);
        return "/pages/test/welcome";
    }
}