package com.project.taskmanagement.repository.user.admin;

import com.project.taskmanagement.controller.user.admin.response.AdminResponse;
import com.project.taskmanagement.repository.user.User;
import com.project.taskmanagement.service.user.model.RoleType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "admin")
@SuperBuilder
public class Admin extends User {
    @Override
    protected void beforeCreate() {
        super.beforeCreate();
        setRoleType(RoleType.ADMIN);
    }

    @Override
    protected void beforeUpdate() {
        super.beforeUpdate();
        setRoleType(RoleType.ADMIN);
    }
    public AdminResponse toAdminResponse(){
        return AdminResponse.builder()
                .name(getName())
                .surname(getSurname())
                .email(getEmail())
                .password(getPassword())
                .roleType(getRoleType().getLabel())
                .build();
    }
}
