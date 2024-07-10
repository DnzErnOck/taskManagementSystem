package com.project.taskmanagement.controller.task.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskRequest {
    @NotBlank(message = "Title cannot be blank")
    String title;
    @NotBlank(message = "Description cannot be blank")
    String description;
    int userId;
}
