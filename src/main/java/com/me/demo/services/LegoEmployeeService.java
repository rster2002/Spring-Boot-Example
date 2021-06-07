package com.me.demo.services;

import com.me.demo.entities.LegoEmployeeEntity;
import com.me.demo.filters.JwtTokenProvider;
import com.me.demo.repositories.LegoEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class LegoEmployeeService {
    @Autowired
    LegoEmployeeRepository legoEmployeeRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String login(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, Arrays.asList(legoEmployeeRepository.findByUsername(username).getRole()));
        } catch (AuthenticationException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid login");
        }
    }

    public String add(LegoEmployeeEntity user) {
        if (legoEmployeeRepository.findByUsername(user.getUsername()) == null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            legoEmployeeRepository.save(user);
            return jwtTokenProvider.createToken(user.getUsername(), Arrays.asList(user.getRole()));
        } else {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Username taken");
        }
    }
}
