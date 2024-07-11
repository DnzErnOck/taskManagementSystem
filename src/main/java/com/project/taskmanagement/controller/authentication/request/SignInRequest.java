package com.project.taskmanagement.controller.authentication.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SignInRequest {
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
