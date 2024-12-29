package com.ELearningPlatform.serviceinterface;

import com.ELearningPlatform.entity.AppUser;

import java.util.Optional;
import java.util.List;

public interface AppUserService {
    AppUser createUser(AppUser user);
    AppUser updateUser(Long id, AppUser user);
    void deleteUser(Long id);
    Optional<AppUser> findByEmail(String email);
    Optional<AppUser> findByUsername(String username);
    List<AppUser> getAllUsers();
    AppUser getUserById(Long id);
}
