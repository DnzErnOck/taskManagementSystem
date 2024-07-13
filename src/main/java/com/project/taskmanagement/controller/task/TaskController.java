package com.project.taskmanagement.controller.task;

import com.project.taskmanagement.controller.BaseController;
import com.project.taskmanagement.controller.task.request.CreateTaskRequest;
import com.project.taskmanagement.controller.task.request.UpdateTaskRequest;
import com.project.taskmanagement.controller.task.response.TaskResponse;
import com.project.taskmanagement.repository.task.Task;
import com.project.taskmanagement.service.task.TaskService;
import com.project.taskmanagement.service.task.model.TaskStatusType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/tasks")
public class TaskController extends BaseController {
    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Void> createTask(@RequestBody CreateTaskRequest createTaskRequest){
        taskService.create(createTaskRequest);
        return answer(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<Void> updateTask(@RequestBody UpdateTaskRequest updateTaskRequest){
        taskService.update(updateTaskRequest);
        return answer(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id){
        taskService.delete(id);
        return answer(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTask(){
        return answer(taskService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getByTaskId(@PathVariable int id){
        return answer(taskService.getById(id),HttpStatus.OK);
    }
    @GetMapping("/ordered")
    public ResponseEntity<List<TaskResponse>> getByCreateDateDesc(@RequestParam(required = false) String sort){
        List<TaskResponse> tasks;
        if (sort != null) {
            tasks = taskService.getAllTasksOrderedByCreateDate(sort);
        } else {
            tasks = taskService.getAllTasksOrderedByCreateDate("asc");
        }
        return answer(tasks,HttpStatus.OK);
    }
    @GetMapping("/status")
    public ResponseEntity<List<TaskResponse>> getByTaskStatusType(@RequestParam TaskStatusType taskStatusType){
        return answer(taskService.getByTaskStatus(taskStatusType),HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TaskResponse>> getTasksByUserId(@PathVariable int userId) {
        return answer(taskService.getTasksByUserId(userId),HttpStatus.OK);
    }
}
