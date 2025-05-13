package com.example.booklibrary.service;

import com.example.booklibrary.model.User_app;
import com.example.booklibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.toList;
@Service
public class CustomerDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository users;
    @Override
    public UserDetails loadUserByUsername(String u) {
        User_app userApp = users.findByUsername(u)
                .orElseThrow(() -> new UsernameNotFoundException(u));
        return new org.springframework.security.core.userdetails.User(
                userApp.getUsername(),
                userApp.getPassword(),
                userApp.getRoles().stream()
                        .map(r->new SimpleGrantedAuthority(r.getName()))
                        .collect(toList())
        );
    }
}
