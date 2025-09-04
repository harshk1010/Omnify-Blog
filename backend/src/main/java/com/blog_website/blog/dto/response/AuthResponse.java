package com.blog_website.blog.dto.response;

import com.blog_website.blog.model.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponse {
    private String token;    // JWT token
    private String message;
    private User userDto;// Success or error message
}
