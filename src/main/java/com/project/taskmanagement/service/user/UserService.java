package com.project.taskmanagement.service.user;

import com.project.taskmanagement.controller.user.request.CreateUserRequest;
import com.project.taskmanagement.controller.user.request.UpdateUserRequest;
import com.project.taskmanagement.controller.user.response.UserResponse;

import java.util.List;

public interface UserService {
    void create(CreateUserRequest createUserRequest);
    void update(UpdateUserRequest updateUserRequest);
    void delete(int id);
    List<UserResponse> getAll();
    UserResponse getById(int id);
}
