package com.project.taskmanagement.service.user;

import com.project.taskmanagement.controller.user.request.CreateUserRequest;
import com.project.taskmanagement.controller.user.request.UpdateUserRequest;
import com.project.taskmanagement.controller.user.response.UserResponse;
import com.project.taskmanagement.repository.user.User;
import com.project.taskmanagement.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserManager implements UserService{
    private  final UserRepository repository;
    @Override
    public void create(CreateUserRequest createUserRequest) {
        repository.save(toEntity(createUserRequest));
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        repository.save(toEntity(updateUserRequest));
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<UserResponse> getAll() {
        List<User> users = repository.findAll();
        List<UserResponse> userResponseList = users.stream().map(user -> user.toResponse()).toList();
        return userResponseList;
    }

    @Override
    public UserResponse getById(int id) {
        return repository.findById(id).orElseThrow().toResponse();
    }

    private User toEntity(CreateUserRequest createUserRequest){
        return User.builder()
                .name(createUserRequest.getName())
                .surname(createUserRequest.getSurname())
                .email(createUserRequest.getEmail())
                .password(createUserRequest.getPassword())
                .build();
    }
    private User toEntity(UpdateUserRequest updateUserRequest){
        return User.builder()
                .id(updateUserRequest.getId())
                .name(updateUserRequest.getName())
                .surname(updateUserRequest.getSurname())
                .email(updateUserRequest.getEmail())
                .password(updateUserRequest.getPassword())
                .build();
    }
}
