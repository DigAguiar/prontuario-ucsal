package com.prontuario.eletronico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.prontuario.eletronico.entities.UserModel;
import com.prontuario.eletronico.exceptions.UserAlreadyExistsException;
import com.prontuario.eletronico.services.UserService;

@Controller()
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/cadastroUser")
    public String createUserPage() {
        return "user/CreateUser";
    }

    @PostMapping("/cadastroUser")
    public String createUserForm(@ModelAttribute UserModel userModel, String role) throws UserAlreadyExistsException {
        userService.saveUser(userModel, role);
        return "user/CreateUser";
    }

}
