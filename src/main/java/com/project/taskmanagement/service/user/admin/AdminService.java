package com.project.taskmanagement.service.user.admin;

import com.project.taskmanagement.controller.user.admin.request.CreateAdminRequest;
import com.project.taskmanagement.controller.user.admin.request.UpdateAdminRequest;
import com.project.taskmanagement.controller.user.admin.response.AdminResponse;

import java.util.List;

public interface AdminService {
    AdminResponse create(CreateAdminRequest adminRequest);
    void update(UpdateAdminRequest updateAdminRequest);
    void delete(int id);
    List<AdminResponse> getAll();
    AdminResponse getById(int id);
}
