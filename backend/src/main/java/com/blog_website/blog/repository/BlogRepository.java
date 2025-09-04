package com.blog_website.blog.repository;


import com.blog_website.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    // Optional: you can add custom queries if needed, for example:
    // List<Blog> findByAuthorId(Long userId);
}
