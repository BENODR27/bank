package com.beno.bank.service.implementation;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.beno.bank.dto.UserDto;
import com.beno.bank.entity.Role;
import com.beno.bank.entity.User;
import com.beno.bank.model.AuthenticationResponseModel;
import com.beno.bank.repository.UserRepository;
import com.beno.bank.security.JwtService;
import com.beno.bank.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Override
    public AuthenticationResponseModel login(UserDto request) {
        Optional<User> userOpt = userRepository.findByEmail(request.getEmail());
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        User user = userOpt.get();
        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        // In real applications, generate a JWT token here
        return AuthenticationResponseModel.builder()
                .token(jwtService.generateToken(user))
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
