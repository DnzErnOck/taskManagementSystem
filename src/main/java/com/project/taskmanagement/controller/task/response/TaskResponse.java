package com.project.taskmanagement.controller.task.response;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskResponse {
    int id;
    String title;
    String description;
    String userName;
    String taskStatus;
    LocalDateTime createdDate;

}
