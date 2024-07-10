package com.project.taskmanagement.service.task;

import com.project.taskmanagement.controller.task.request.CreateTaskRequest;
import com.project.taskmanagement.controller.task.request.UpdateTaskRequest;
import com.project.taskmanagement.controller.task.response.TaskResponse;
import com.project.taskmanagement.repository.task.TaskRespository;
import com.project.taskmanagement.service.task.model.TaskStatusType;

import java.util.List;

public interface TaskService {
    void create(CreateTaskRequest createTaskRequest);
    void update(UpdateTaskRequest updateTaskRequest);
    void delete(int id);
    List<TaskResponse> getAll();
    TaskResponse getById(int id);

    List<TaskResponse> getByCreateDateDesc();

    List<TaskResponse> getByTaskStatus(TaskStatusType taskStatusType);

}
