package com.projecttest.crud.web.controllers;

import com.projecttest.crud.web.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserController {
    List<UserDTO> getAllUsers();

    ResponseEntity<UserDTO> getUserById(Long id);

    UserDTO createUser(UserDTO user);

    ResponseEntity<UserDTO> updateUser(Long id, UserDTO userDetails);

    ResponseEntity<Void> deleteUser(Long id);
}