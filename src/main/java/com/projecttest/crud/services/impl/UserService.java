package com.projecttest.crud.services.impl;

import com.projecttest.crud.entities.UserEntity;
import com.projecttest.crud.repositories.UserRepository;
import com.projecttest.crud.services.IUserService;
import com.projecttest.crud.web.dto.UserDTO;
import com.projecttest.crud.web.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;import java.util.Optional;


@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return userMapper.toDtoList(users);
    }

    @Override
    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findById(id).map(userMapper::toDto);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        System.out.println("Received UserDTO: " + userDTO);
        UserEntity user = userMapper.toEntity(userDTO);
        System.out.println("Received UserEntity: " + user);

        UserEntity savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.updateEntityFromDto(userDTO, user);
        UserEntity updatedUser = userRepository.save(user);
        return userMapper.toDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
