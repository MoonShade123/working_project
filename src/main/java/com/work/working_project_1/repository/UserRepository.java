package com.work.working_project_1.repository;

import com.work.working_project_1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(final String username);

    User findByPhoneNumber(final String phoneNumber);

    public User findByResetPasswordToken(String token);
}
