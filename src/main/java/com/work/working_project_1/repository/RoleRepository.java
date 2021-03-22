package com.work.working_project_1.repository;

import com.work.working_project_1.commons.UserRole;
import com.work.working_project_1.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByUserRole(UserRole userRole);
}

