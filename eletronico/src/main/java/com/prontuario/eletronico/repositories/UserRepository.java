package com.prontuario.eletronico.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prontuario.eletronico.entities.UserModel;

public interface UserRepository extends JpaRepository<UserModel,Integer>{
    Optional<UserModel> findByEmail(String email);

    @Query("SELECT u from UserModel u JOIN FETCH u.roles where u.email = :email")
    UserModel findByEmailFetchRoles(@Param("email") String email);
}
