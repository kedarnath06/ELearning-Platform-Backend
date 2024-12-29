package com.ELearningPlatform.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "app_users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Email is mandatory")
    @Pattern(
            regexp = "^[a-z0-9+_.-]+@(gmail\\.com|yahoo\\.com|outlook\\.com|hotmail\\.com)$",
            message = "Email must be lowercase and from a valid provider (gmail.com, yahoo.com, outlook.com, hotmail.com)"
    )
    private String email;

    @NotBlank(message = "Username is mandatory")
    @Size(min = 5, max = 50, message = "Username must be between 5 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z0-9._-]+$", message = "Username can only contain letters, numbers, dots, underscores, and hyphens")
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,16}$",
            message = "Password must be 6-16 characters long, include at least 1 uppercase letter, 1 lowercase letter, 1 digit, and 1 special character"
    )
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}