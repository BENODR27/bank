package com.beno.bank.service;

import com.beno.bank.dto.UserDto;

public interface AuthenticationService {
    public UserDto register(UserDto request);

    public UserDto login(UserDto request);
}
