package com.prontuario.eletronico.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.prontuario.eletronico.entities.Role;
import com.prontuario.eletronico.entities.UserModel;
import com.prontuario.eletronico.exceptions.UserAlreadyExistsException;
import com.prontuario.eletronico.repositories.RoleRepository;
import com.prontuario.eletronico.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public String saveUser(UserModel userModel, String role) throws UserAlreadyExistsException {
        UserModel existsUser = userRepository.findByEmailFetchRoles(userModel.getEmail());

        if (existsUser != null) {
            throw new UserAlreadyExistsException();
        }
        userModel.setPassword(passwordEncoder().encode(userModel.getPassword()));
        var listRoles = new ArrayList<Role>();
        var result = roleRepository.findByName(role);
        listRoles.add(result);
        userModel.setRoles(listRoles);

        UserModel user = userRepository.save(userModel);

        return "ok";
    }
}
