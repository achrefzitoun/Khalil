package com.example.back.Services;

import com.example.back.Entites.Dto.AuthenticationRequest;
import com.example.back.Entites.Dto.AuthenticationResponse;
import com.example.back.Entites.Dto.RegisterRequest;

public interface IAuthenticationServices {
    public AuthenticationResponse register(RegisterRequest request);
    public AuthenticationResponse authenticate(AuthenticationRequest request);
}
