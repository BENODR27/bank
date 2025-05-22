package com.beno.bank.service.implementation;

import org.springframework.stereotype.Service;

import com.beno.bank.dto.UserDto;
import com.beno.bank.entity.Role;
import com.beno.bank.entity.User;
import com.beno.bank.repository.UserRepository;
import com.beno.bank.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    @Override
    public UserDto login(UserDto request) {
        return UserDto.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }

    @Override
    public UserDto register(UserDto request) {
        // Convert UserDto to User entity
        User user = new User();
        user.setName(request.getName());
        user.setPhone(request.getPhone());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(Role.USER); // Set default role to USER

        // Save the User entity
        User savedUser = userRepository.save(user);

        // Convert the saved User entity back to UserDto
        return UserDto.builder()
                .name(savedUser.getName())
                .phone(savedUser.getPhone())
                .email(savedUser.getEmail())
                .password(savedUser.getPassword())
                .build();
    }
}
