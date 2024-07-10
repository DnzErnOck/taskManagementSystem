package com.project.taskmanagement.controller.task.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskResponse {
    String title;
    String description;
    String userName;
    String taskStatus;
}
