package com.blog_website.blog.service;

import com.blog_website.blog.dto.request.BlogRequest;
import com.blog_website.blog.dto.response.BlogResponse;

import java.util.List;

public interface BlogService {

    BlogResponse createBlog(String token, BlogRequest request);

    List<BlogResponse> getAllBlogs(int page, int size);

    BlogResponse getBlogById(Long id);

    BlogResponse updateBlog(String token, Long id, BlogRequest request);

    void deleteBlog(String token, Long id);
}
