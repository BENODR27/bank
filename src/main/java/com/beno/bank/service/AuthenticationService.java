package com.beno.bank.service;

import com.beno.bank.dto.UserDto;
import com.beno.bank.model.AuthenticationResponseModel;

public interface AuthenticationService {
    public UserDto register(UserDto request);

    public AuthenticationResponseModel login(UserDto request);
}
