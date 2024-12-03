package com.example.back.Services.impl;

import com.example.back.Configration.JwtService;
import com.example.back.Entites.Dto.AuthenticationRequest;
import com.example.back.Entites.Dto.AuthenticationResponse;
import com.example.back.Entites.Dto.RegisterRequest;
import com.example.back.Entites.Role;
import com.example.back.Entites.User;
import com.example.back.Entites.auth.Token;
import com.example.back.Entites.auth.TokenType;
import com.example.back.Repositories.IUserRepository;
import com.example.back.Repositories.auth.TokenRepository;
import com.example.back.Services.IAuthenticationServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class authenticationServices implements IAuthenticationServices {
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;
    private final TokenRepository tokenRepository;
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String generateRandomString() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstname())
                .secondName(request.getLastname())
                .birthDate(request.getBirthDate())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .identifier(request.getIdentifier())
                .pwd(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .dateCreation(LocalDate.now())
                .numUSer(generateRandomString())
                .build();
        var savedUser = userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        saveUserToken(savedUser, jwtToken);
        return new AuthenticationResponse(jwtToken);

    }


    private void saveUserToken(User user, String jwtToken) {
        var token= Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .revoked(false)
                .expired(false)
                .build();
        tokenRepository.save(token);
    }


    private void revokeAllCompteTokens(User user) {
        var validCompteTokens = tokenRepository.findAllValidTokensByCompte(user.getIdUser());
        if(validCompteTokens.isEmpty()){
            return;
        }
        validCompteTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validCompteTokens);
    }
    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        revokeAllCompteTokens(user);

        var jwtToken = jwtService.generateToken(user);
        saveUserToken(user,jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }



}
