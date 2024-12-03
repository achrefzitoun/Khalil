package com.example.back.Controllers;


import com.example.back.Configration.JwtService;
import com.example.back.Entites.Dto.AuthenticationRequest;
import com.example.back.Entites.Dto.AuthenticationResponse;
import com.example.back.Entites.Dto.RegisterRequest;
import com.example.back.Services.IAuthenticationServices;

import com.example.back.Services.impl.LogoutService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthenticationController {

    private final IAuthenticationServices authenticationService;

    public final JwtService jwtService;

    private final LogoutService logoutService ;

    @PostMapping("/register")
    public AuthenticationResponse register(@RequestBody RegisterRequest request) {
        return authenticationService.register(request);

    }

    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse> authentication(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request,
                                       HttpServletResponse response,
                                       Authentication authentication) {
        logoutService.logout(request, response, authentication);
        return ResponseEntity.ok().build();
    }



}


