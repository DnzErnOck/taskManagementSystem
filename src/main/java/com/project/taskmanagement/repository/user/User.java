package com.project.taskmanagement.repository.user;

import com.project.taskmanagement.controller.user.response.UserResponse;
import com.project.taskmanagement.core.Base;
import com.project.taskmanagement.repository.task.Task;
import com.project.taskmanagement.service.user.model.RoleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public class User extends Base {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role_type")
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;
    @Override
    protected void beforeCreate() {
        super.beforeCreate();
        setRoleType(RoleType.USER);
    }

    @Override
    protected void beforeUpdate() {
        super.beforeUpdate();
        setRoleType(RoleType.USER);
    }
    public UserResponse toResponse(){
        return UserResponse.builder()
                .id(this.getId())
                .name(this.name)
                .surname(this.surname)
                .email(this.email)
                .password(this.password)
                .roleType(this.roleType.getLabel())
                .build();
    }
    public static User fromResponse(UserResponse response){
        return User.builder()
                .id(response.getId())
                .name(response.getName())
                .surname(response.getSurname())
                .email(response.getEmail())
                .password(response.getPassword())
                .roleType(RoleType.fromString(response.getRoleType()))
                .build();
    }
}
