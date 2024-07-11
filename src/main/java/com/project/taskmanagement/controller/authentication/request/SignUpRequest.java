package com.project.taskmanagement.controller.authentication.request;

import com.project.taskmanagement.controller.user.admin.request.CreateAdminRequest;
import com.project.taskmanagement.controller.user.request.CreateUserRequest;
import com.project.taskmanagement.service.user.model.RoleType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SignUpRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private RoleType roleType;

    public CreateAdminRequest forAdmin() {
        return CreateAdminRequest.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .build();
    }

    public CreateUserRequest forUser() {
        return CreateUserRequest.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .build();
    }
}
