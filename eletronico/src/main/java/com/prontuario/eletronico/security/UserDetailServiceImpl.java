package com.prontuario.eletronico.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prontuario.eletronico.entities.UserModel;
import com.prontuario.eletronico.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService{

    final UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));
            return UserPrincipal.create(userModel);
    }
}
