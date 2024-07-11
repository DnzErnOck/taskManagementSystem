package com.project.taskmanagement.repository.task;

import com.project.taskmanagement.controller.task.response.TaskResponse;
import com.project.taskmanagement.core.Base;
import com.project.taskmanagement.repository.user.User;
import com.project.taskmanagement.service.task.model.TaskStatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
@SuperBuilder
public class Task extends Base {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "task_status")
    @Enumerated(EnumType.STRING)
    private TaskStatusType taskStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Override
    protected void beforeCreate() {
        super.beforeCreate();
        setTaskStatus(TaskStatusType.NEW);
    }
    public TaskResponse toResponse(){
        return TaskResponse.builder()
                .id(getId())
                .title(title)
                .description(description)
                .taskStatus(taskStatus.getLabel())
                .userName(user.getName())
                .createdDate(getCreatedDate())
                .build();
    }

}
