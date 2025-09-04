package com.blog_website.blog.service;

import com.blog_website.blog.config.JwtConstant;
import com.blog_website.blog.model.User;
import com.blog_website.blog.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    // ---------------- Find user from JWT token ----------------
    @Override
    public User findUserByJwtToken(String jwt) throws Exception {
        if (jwt == null || !jwt.startsWith("Bearer ")) {
            throw new Exception("Invalid JWT token");
        }

        // Parse JWT
        SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt.substring(7))  // remove "Bearer "
                .getBody();

        String email = claims.get("email", String.class);
        if (email == null || email.isEmpty()) {
            throw new Exception("Email not found in token");
        }

        return findUserByEmail(email);
    }

    // ---------------- Find user by email ----------------
    @Override
    public User findUserByEmail(String email) throws Exception {
        return userRepository.findByEmail(email.toLowerCase())
                .orElseThrow(() -> new Exception("User not found with email: " + email));
    }
}
