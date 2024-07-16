package com.project.taskmanagement.repository.task;

import com.project.taskmanagement.controller.task.response.TaskResponse;
import com.project.taskmanagement.service.task.model.TaskStatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRespository extends JpaRepository<Task,Integer> {
    List<Task> findByUserId(int userId);
    List<Task> findAllByOrderByCreatedDateDesc();

    List<Task> findAllByOrderByCreatedDateAsc();

    List<Task> findByTaskStatusOrderByCreatedDateDesc(@Param("status") TaskStatusType status);

    @Query("SELECT t FROM Task t WHERE "
            + "( :userId IS NULL OR t.user.id = :userId ) AND "
            + "( :status IS NULL OR t.taskStatus = :status ) "
            + "ORDER BY "
            + "CASE WHEN :sortOrder = 'asc' THEN t.createdDate END ASC, "
            + "CASE WHEN :sortOrder = 'desc' THEN t.createdDate END DESC")
    List<Task> findByUserIdAndStatusWithSort(
            @Param("userId") Integer userId,
            @Param("status") TaskStatusType status,
            @Param("sortOrder") String sortOrder);



}
