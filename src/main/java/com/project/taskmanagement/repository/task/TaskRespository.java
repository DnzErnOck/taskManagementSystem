package com.project.taskmanagement.repository.task;

import com.project.taskmanagement.controller.task.response.TaskResponse;
import com.project.taskmanagement.service.task.model.TaskStatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRespository extends JpaRepository<Task,Integer> {
    List<Task> findByUserId(int userId);
    List<Task> findAllByOrderByCreatedDateDesc();

    List<Task> findAllByOrderByCreatedDateAsc();

    List<Task> findByTaskStatusOrderByCreatedDateDesc(@Param("status") TaskStatusType status);
}
