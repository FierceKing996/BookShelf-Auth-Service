package com.example.booklibrary.controller;

import com.example.booklibrary.dto.AuthResponse;
import com.example.booklibrary.dto.LoginDTO;
import com.example.booklibrary.dto.SignupDTO;
import com.example.booklibrary.model.Role;
import com.example.booklibrary.model.User_app;
import com.example.booklibrary.repository.RoleRepository;
import com.example.booklibrary.repository.UserRepository;
import com.example.booklibrary.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupDTO dto) {
        if (userRepository.existsByUsername(dto.getUsername())) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Username is already taken.");
        }

        // Create a new userApp object
        User_app userApp = new User_app();
        userApp.setUsername(dto.getUsername());
        userApp.setPassword(passwordEncoder.encode(dto.getPassword()));

        // Assign default role (e.g., ROLE_USER)
        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Default role not found"));
        userApp.getRoles().add(userRole);

        // Save userApp to database
        userRepository.save(userApp);

        return ResponseEntity.ok("User_app registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginDTO dto) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        UserDetails ud = userDetailsService.loadUserByUsername(dto.getUsername());
        String token = jwtUtil.generateToken(ud.getUsername());
        return ResponseEntity.ok(new AuthResponse(token, dto.getUsername(), "Login successful"));
    }
}
