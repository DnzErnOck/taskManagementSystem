package com.project.taskmanagement.controller.user.admin.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminResponse {
    private String name;

    private String surname;

    private String email;

    private String password;

    private String roleType;
}
