package com.project.taskmanagement.service.auth;

import com.project.taskmanagement.controller.authentication.request.SignInRequest;
import com.project.taskmanagement.controller.authentication.request.SignUpRequest;
import com.project.taskmanagement.core.security.model.JwtToken;

public interface AuthenticationService {
    void signUp(SignUpRequest request);

    JwtToken signIn(SignInRequest request);

    boolean isUserTrue(String email, String password);
}
