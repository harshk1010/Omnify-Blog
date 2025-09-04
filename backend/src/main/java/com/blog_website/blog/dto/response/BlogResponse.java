package com.blog_website.blog.dto.response;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogResponse {
    private Long id;
    private String title;
    private String content;
    private String authorName;       // changed from authorEmail
    private LocalDateTime createdAt; // added creation timestamp
}
