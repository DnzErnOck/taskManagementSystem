package com.project.taskmanagement.service.user;

import com.project.taskmanagement.controller.user.request.CreateUserRequest;
import com.project.taskmanagement.controller.user.request.UpdateUserRequest;
import com.project.taskmanagement.controller.user.response.UserResponse;

import com.project.taskmanagement.repository.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService extends UserDetailsService {
    void create(CreateUserRequest createUserRequest);
    void update(UpdateUserRequest updateUserRequest);
    void delete(int id);
    List<UserResponse> getAll();
    UserResponse getById(int id);
    @Transactional
    User getByEmail(String emailAddress);
}
