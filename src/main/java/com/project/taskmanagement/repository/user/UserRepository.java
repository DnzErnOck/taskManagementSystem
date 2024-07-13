package com.project.taskmanagement.repository.user;

import com.project.taskmanagement.service.user.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmailIgnoreCase(String emailAddress);

    List<User> findByRoleType(RoleType roleType);;
}
