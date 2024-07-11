package com.project.taskmanagement.service.user;

import com.project.taskmanagement.controller.user.request.CreateUserRequest;
import com.project.taskmanagement.controller.user.request.UpdateUserRequest;
import com.project.taskmanagement.controller.user.response.UserResponse;
import com.project.taskmanagement.core.exception.NotFoundException;
import com.project.taskmanagement.core.exception.type.NotFoundExceptionType;
import com.project.taskmanagement.repository.user.User;
import com.project.taskmanagement.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserManager implements UserService{
    private  final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void create(CreateUserRequest createUserRequest) {
        createUserRequest.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
        repository.save(toEntity(createUserRequest));
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        updateUserRequest.setPassword(passwordEncoder.encode(updateUserRequest.getPassword()));
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

    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
        User user = getByEmail(emailAddress);
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(user.getRoleType().name())
                .build();
    }

    @Override
    public User getByEmail(String emailAddress) {
        return this.repository.findByEmailIgnoreCase(emailAddress).orElseThrow(() -> new NotFoundException(
                NotFoundExceptionType.USER_DATA_NOT_FOUND));
    }

}
