package com.ELearningPlatform.serviceinterface;

import com.ELearningPlatform.entity.Role;
import com.ELearningPlatform.entity.RoleName;

import java.util.Optional;
import java.util.List;

public interface RoleService {
    Role createRole(Role role);
    Role updateRole(Long id, Role role);
    void deleteRole(Long id);
    Optional<Role> findByRoleName(RoleName roleName);
    List<Role> getAllRoles();
}
