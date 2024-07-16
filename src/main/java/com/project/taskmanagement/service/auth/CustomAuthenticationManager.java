package com.project.taskmanagement.service.auth;

import com.project.taskmanagement.controller.authentication.request.SignInRequest;
import com.project.taskmanagement.controller.authentication.request.SignUpRequest;
import com.project.taskmanagement.core.exception.NotFoundException;
import com.project.taskmanagement.core.exception.type.NotFoundExceptionType;
import com.project.taskmanagement.core.security.JwtService;
import com.project.taskmanagement.core.security.model.JwtToken;
import com.project.taskmanagement.repository.user.User;
import com.project.taskmanagement.service.user.UserRules;
import com.project.taskmanagement.service.user.UserService;
import com.project.taskmanagement.service.user.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class CustomAuthenticationManager implements AuthenticationService{
    private final AdminService adminService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final UserRules userRules;

    @Override
    public void signUp(SignUpRequest request) {

        userRules.existsByEmailAddress(request.getEmail());
        switch (request.getRoleType()) {
            case ADMIN -> this.adminService.create(request.forAdmin());
            case USER -> {
                this.userService.create(request.forUser());
            }
            default -> throw new NotFoundException(NotFoundExceptionType.USER_ROLE_NOT_FOUND);
        }
    }

    @Transactional
    public JwtToken signIn(SignInRequest request) {
        User user = userService.getByEmail(request.getEmail());

        if (isUserTrue(request.getEmail(), request.getPassword())) {
            String token = jwtService.generateToken(user);
            return JwtToken.builder().token(token).build();
        }
        throw new RuntimeException("Bilgiler hatalı");
    }

    @Override
    public boolean isUserTrue(String emailAddress, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(emailAddress, password)
        );
        return authentication.isAuthenticated();
    }
}
