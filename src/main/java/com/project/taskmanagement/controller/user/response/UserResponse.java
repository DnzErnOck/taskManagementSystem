package com.project.taskmanagement.controller.user.response;

import com.project.taskmanagement.service.user.model.RoleType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private int id;
    private String name;

    private String surname;

    private String email;

    private String roleType;

    private String password;

}
