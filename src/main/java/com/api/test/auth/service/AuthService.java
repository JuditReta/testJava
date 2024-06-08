package com.api.test.auth.service;

import com.api.test.auth.model.*;
import com.api.test.auth.repository.UserRepository;
import com.api.test.demojwt.Jwt.Service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private FabricUserService fabricUserService;

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword()))
                .rol(Rol.User)
                .creationDate(new Date())
                .details("Se creo el perfil")
                .build();

        //userRepository.save(user);

        userRepository.save(fabricUserService.createUser(fabricUserService.createUserDTO(user)));

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();

    }
}
