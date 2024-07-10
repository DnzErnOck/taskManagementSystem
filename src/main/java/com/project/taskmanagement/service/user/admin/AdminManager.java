package com.project.taskmanagement.service.user.admin;

import com.project.taskmanagement.controller.user.admin.request.CreateAdminRequest;
import com.project.taskmanagement.controller.user.admin.request.UpdateAdminRequest;
import com.project.taskmanagement.controller.user.admin.response.AdminResponse;
import com.project.taskmanagement.controller.user.response.UserResponse;
import com.project.taskmanagement.repository.user.User;
import com.project.taskmanagement.repository.user.admin.Admin;
import com.project.taskmanagement.repository.user.admin.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminManager implements AdminService{
    private final AdminRepository repository;
    @Override
    public void create(CreateAdminRequest createAdminRequest) {
        repository.save(toEntityAdmin(createAdminRequest));
    }

    @Override
    public void update(UpdateAdminRequest updateAdminRequest) {
        repository.save(toEntityAdmin(updateAdminRequest));
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<AdminResponse> getAll() {
        List<Admin> admins = repository.findAll();
        List<AdminResponse> adminResponseList = admins.stream().map(admin -> admin.toAdminResponse()).toList();
        return adminResponseList;
    }

    @Override
    public AdminResponse getById(int id) {
        return repository.findById(id).orElseThrow().toAdminResponse();
    }

    private Admin toEntityAdmin(CreateAdminRequest createAdminRequest){
        return Admin.builder()
                .name(createAdminRequest.getName())
                .surname(createAdminRequest.getSurname())
                .email(createAdminRequest.getEmail())
                .password(createAdminRequest.getPassword())
                .build();
    }
    private Admin toEntityAdmin(UpdateAdminRequest updateAdminRequest){
        return Admin.builder()
                .id(updateAdminRequest.getId())
                .name(updateAdminRequest.getName())
                .surname(updateAdminRequest.getSurname())
                .email(updateAdminRequest.getEmail())
                .password(updateAdminRequest.getPassword())
                .build();
    }
}
