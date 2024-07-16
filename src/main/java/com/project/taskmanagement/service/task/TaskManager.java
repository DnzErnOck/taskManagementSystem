package com.project.taskmanagement.service.task;

import com.project.taskmanagement.controller.task.request.CreateTaskRequest;
import com.project.taskmanagement.controller.task.request.UpdateTaskRequest;
import com.project.taskmanagement.controller.task.response.TaskResponse;
import com.project.taskmanagement.controller.user.request.CreateUserRequest;
import com.project.taskmanagement.repository.task.Task;
import com.project.taskmanagement.repository.task.TaskRespository;
import com.project.taskmanagement.repository.user.User;
import com.project.taskmanagement.service.task.model.TaskStatusType;
import com.project.taskmanagement.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TaskManager implements TaskService{
    private final TaskRespository repository;
    private final UserService userService;
    @Override
    public void create(CreateTaskRequest createTaskRequest) {
        repository.save(toEntity(createTaskRequest));
    }

    @Override
    public void update(UpdateTaskRequest updateTaskRequest) {
        repository.save(toEntity(updateTaskRequest));
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<TaskResponse> getAll() {
        List<Task> taskList = repository.findAll();
        List<TaskResponse> taskResponses = taskList.stream().map(task -> task.toResponse()).toList();
        return taskResponses;
    }

    @Override
    public TaskResponse getById(int id) {
        return repository.findById(id).orElseThrow().toResponse();
    }

    @Override
    public List<TaskResponse> getTasksByUserId(int userId) {
        List<Task> taskList = repository.findByUserId(userId);
        List<TaskResponse> taskResponses =  taskList.stream().map(task -> task.toResponse()).toList();
        return taskResponses;
    }

    @Override
    public List<TaskResponse> getAllTasksOrderedByCreateDate(String order) {
        List<Task> taskList;
        if ("asc".equalsIgnoreCase(order)) {
            taskList = repository.findAllByOrderByCreatedDateAsc();
        } else {
            taskList = repository.findAllByOrderByCreatedDateDesc();
        }
        List<TaskResponse> taskResponses = taskList.stream().map(task -> task.toResponse()).toList();
        return taskResponses;
    }

    @Override
    public List<TaskResponse> getByTaskStatus(TaskStatusType taskStatusType) {
        List<Task> taskList = repository.findByTaskStatusOrderByCreatedDateDesc(taskStatusType);
        List<TaskResponse> taskResponses = taskList.stream().map(task -> task.toResponse()).toList();
        return taskResponses;
    }

    @Override
    public List<TaskResponse> getByUserIdAndStatusWithSort(Integer userId, TaskStatusType status, String sortOrder) {
        List<Task> taskList = repository.findByUserIdAndStatusWithSort(userId,status,sortOrder);
        List<TaskResponse> taskResponses = taskList.stream().map(task -> task.toResponse()).toList();
        return taskResponses;
    }

    public Task toEntity(CreateTaskRequest createTaskRequest){
        return Task.builder()
                .title(createTaskRequest.getTitle())
                .description(createTaskRequest.getDescription())
                .user(User.fromResponse(userService.getById(createTaskRequest.getUserId())))
                .build();
    }
    public Task toEntity(UpdateTaskRequest updateTaskRequest){
        return Task.builder()
                .id(updateTaskRequest.getId())
                .title(updateTaskRequest.getTitle())
                .description(updateTaskRequest.getDescription())
                .taskStatus(TaskStatusType.fromString(updateTaskRequest.getTaskStatus()))
                .user(User.fromResponse(userService.getById(updateTaskRequest.getUserId())))
                .build();
    }
}
