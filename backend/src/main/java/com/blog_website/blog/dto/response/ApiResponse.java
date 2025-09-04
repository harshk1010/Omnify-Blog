package com.blog_website.blog.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T> {
    private boolean success;   // true/false
    private String message;    // description of result
    private T data;            // actual payload (BlogResponse, AuthResponse, etc.)
}
