package com.projecttest.crud.web.controllers.impl;

import com.projecttest.crud.services.IUserService;
import com.projecttest.crud.web.controllers.IUserController;
import com.projecttest.crud.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController implements IUserController {


        @Autowired
        private IUserService userService;
        @Override
        @GetMapping
        public List<UserDTO> getAllUsers() {
            return userService.getAllUsers();
        }

        @Override
        @GetMapping("/{id}")
        public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
            return userService.getUserById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @Override
        @PostMapping
        public UserDTO createUser(@RequestBody UserDTO userDTO) {
            return userService.createUser(userDTO);
        }

        @Override
        @PutMapping("/{id}")
        public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
            try {
                UserDTO updatedUser = userService.updateUser(id, userDTO);
                return ResponseEntity.ok(updatedUser);
            } catch (RuntimeException e) {
                return ResponseEntity.notFound().build();
            }
        }

        @Override
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        }
}
