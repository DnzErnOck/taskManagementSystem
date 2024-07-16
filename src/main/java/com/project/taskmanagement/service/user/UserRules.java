package com.project.taskmanagement.service.user;

import com.project.taskmanagement.core.exception.AlreadyExistsException;
import com.project.taskmanagement.core.exception.NotFoundException;
import com.project.taskmanagement.core.exception.type.AlreadyExistsExceptionType;
import com.project.taskmanagement.core.exception.type.NotFoundExceptionType;
import com.project.taskmanagement.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserRules {
    private final UserRepository repository;

    public void existsByEmailAddress(String email) {
        if (repository.existsByEmail(email)) {
            throw new AlreadyExistsException(AlreadyExistsExceptionType.EMAIL_ADDRESS_ALREADY_EXISTS);
        }
    }
}
