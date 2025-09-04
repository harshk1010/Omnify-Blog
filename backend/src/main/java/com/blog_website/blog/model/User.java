package com.blog_website.blog.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)  // email must be unique
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name; // user name

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private USER_ROLE role;


}
