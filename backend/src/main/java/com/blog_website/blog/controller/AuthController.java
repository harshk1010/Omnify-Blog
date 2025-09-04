package com.blog_website.blog.controller;

import com.blog_website.blog.config.JwtProvider;
import com.blog_website.blog.dto.request.AuthRequest;
import com.blog_website.blog.dto.response.AuthResponse;
import com.blog_website.blog.model.USER_ROLE;
import com.blog_website.blog.model.User;
import com.blog_website.blog.repository.UserRepository;
import com.blog_website.blog.service.CustomerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private CustomerUserDetailsService customerUserDetailsService;

    // ------------------- SIGNUP -------------------
    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody AuthRequest request) throws Exception {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new Exception("Email is already used with another account");
        }

        // Create new user
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setName(request.getName());
        user.setRole(USER_ROLE.ROLE_USER); // ✅ Set default role
        userRepository.save(user);

        // Authenticate newly created user
        Authentication authentication = authenticate(request.getEmail(), request.getPassword());

        // Generate JWT token
        String jwt = jwtProvider.generateToken(authentication);

        AuthResponse response = AuthResponse.builder()
                .token(jwt)
                .message("Register success")
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    // ------------------- LOGIN -------------------
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

        Authentication authentication = authenticate(request.getEmail(), request.getPassword());

        String jwt = jwtProvider.generateToken(authentication);

        AuthResponse response = AuthResponse.builder()
                .token(jwt)
                .message("Login success")
                .userDto(userRepository.findByEmail(request.getEmail()).get()) // ✅ include user
                .build();


        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // ------------------- HELPER METHOD -------------------
    private Authentication authenticate(String email, String password) {

        var userDetails = customerUserDetailsService.loadUserByUsername(email);

        if (userDetails == null) {
            throw new BadCredentialsException("Invalid email");
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return authentication;
    }
}
