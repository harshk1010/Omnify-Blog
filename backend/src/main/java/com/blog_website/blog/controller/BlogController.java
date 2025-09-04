package com.blog_website.blog.controller;

import com.blog_website.blog.dto.request.BlogRequest;
import com.blog_website.blog.dto.response.ApiResponse;
import com.blog_website.blog.dto.response.BlogResponse;
import com.blog_website.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    // ✅ Create Blog (only logged-in users)
    @PostMapping
    public ResponseEntity<ApiResponse<BlogResponse>> createBlog(
            @RequestHeader("Authorization") String token,
            @RequestBody BlogRequest request) {

        BlogResponse blog = blogService.createBlog(token, request);
        return ResponseEntity.ok(ApiResponse.<BlogResponse>builder()
                .success(true)
                .message("Blog created successfully")
                .data(blog)
                .build());
    }

    // ✅ Get all blogs (public, with pagination)
    @GetMapping
    public ResponseEntity<ApiResponse<List<BlogResponse>>> getAllBlogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        List<BlogResponse> blogs = blogService.getAllBlogs(page, size);
        return ResponseEntity.ok(ApiResponse.<List<BlogResponse>>builder()
                .success(true)
                .message("Fetched blogs successfully")
                .data(blogs)
                .build());
    }

    // ✅ Get single blog by ID (public)
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BlogResponse>> getBlogById(@PathVariable Long id) {
        BlogResponse blog = blogService.getBlogById(id);
        return ResponseEntity.ok(ApiResponse.<BlogResponse>builder()
                .success(true)
                .message("Fetched blog successfully")
                .data(blog)
                .build());
    }

    // ✅ Update blog (only by author)
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BlogResponse>> updateBlog(
            @RequestHeader("Authorization") String token,
            @PathVariable Long id,
            @RequestBody BlogRequest request) {

        BlogResponse blog = blogService.updateBlog(token, id, request);
        return ResponseEntity.ok(ApiResponse.<BlogResponse>builder()
                .success(true)
                .message("Blog updated successfully")
                .data(blog)
                .build());
    }

    // ✅ Delete blog (only by author)
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteBlog(
            @RequestHeader("Authorization") String token,
            @PathVariable Long id) {

        blogService.deleteBlog(token, id);
        return ResponseEntity.ok(ApiResponse.<Void>builder()
                .success(true)
                .message("Blog deleted successfully")
                .data(null)
                .build());
    }
}
