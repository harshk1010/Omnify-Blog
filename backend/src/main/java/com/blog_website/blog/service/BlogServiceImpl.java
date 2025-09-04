package com.blog_website.blog.service;

import com.blog_website.blog.dto.request.BlogRequest;
import com.blog_website.blog.dto.response.BlogResponse;
import com.blog_website.blog.exception.ResourceNotFoundException;
import com.blog_website.blog.model.Blog;
import com.blog_website.blog.model.User;
import com.blog_website.blog.repository.BlogRepository;
import com.blog_website.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.blog_website.blog.exception.ResourceNotFoundException;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    // Helper method to extract User from JWT token
    private User getUserFromToken(String token) {
        // Extract email from JWT
        String email = jwtUtil.getEmailFromToken(token);

        // Find user by email
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
    }



    // Convert Blog entity to BlogResponse DTO
    private BlogResponse mapToResponse(Blog blog) {
        return BlogResponse.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .content(blog.getContent())
                .authorName(blog.getAuthor().getName())
                .createdAt(blog.getCreatedAt())
                .build();
    }

    @Override
    public BlogResponse createBlog(String token, BlogRequest request) {
        User user = getUserFromToken(token);

        Blog blog = Blog.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .author(user)
                .createdAt(LocalDateTime.now())
                .build();

        Blog saved = blogRepository.save(blog);
        return mapToResponse(saved);
    }

    @Override
    public List<BlogResponse> getAllBlogs(int page, int size) {
        return blogRepository.findAll(PageRequest.of(page, size))
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BlogResponse getBlogById(Long id) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found with id: " + id));
        return mapToResponse(blog);
    }

    @Override
    public BlogResponse updateBlog(String token, Long id, BlogRequest request) {
        User user = getUserFromToken(token);

        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found with id: " + id));

        if (!blog.getAuthor().getEmail().equals(user.getEmail())) {
            throw new RuntimeException("You are not authorized to update this blog");
        }

        blog.setTitle(request.getTitle());
        blog.setContent(request.getContent());
        Blog updated = blogRepository.save(blog);
        return mapToResponse(updated);
    }

    @Override
    public void deleteBlog(String token, Long id) {
        User user = getUserFromToken(token);

        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found with id: " + id));

        if (!blog.getAuthor().getEmail().equals(user.getEmail())) {
            throw new RuntimeException("You are not authorized to delete this blog");
        }

        blogRepository.delete(blog);
    }
}
