package com.ELearningPlatform.serviceimplementation;

import com.ELearningPlatform.entity.AppUser;
import com.ELearningPlatform.exception.UserNotFoundException;
import com.ELearningPlatform.exception.DuplicateEmailException;
import com.ELearningPlatform.repository.AppUserRepository;
import com.ELearningPlatform.serviceinterface.AppUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;

    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    @Transactional
    public AppUser createUser(AppUser user) {
        if (appUserRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateEmailException(user.getEmail());
        }
        return appUserRepository.save(user);
    }

    @Override
    @Transactional
    public AppUser updateUser(Long id, AppUser user) {
        AppUser existingUser = appUserRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        if (!existingUser.getEmail().equals(user.getEmail()) &&
                appUserRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateEmailException(user.getEmail());
        }

        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setRoles(user.getRoles());
        return appUserRepository.save(existingUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        if (!appUserRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        appUserRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AppUser> findByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AppUser> findByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public AppUser getUserById(Long id) {
        return appUserRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
