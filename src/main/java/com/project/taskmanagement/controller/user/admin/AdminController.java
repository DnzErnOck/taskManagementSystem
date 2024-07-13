package com.project.taskmanagement.controller.user.admin;

import com.project.taskmanagement.controller.BaseController;
import com.project.taskmanagement.controller.user.admin.request.CreateAdminRequest;
import com.project.taskmanagement.controller.user.admin.request.UpdateAdminRequest;
import com.project.taskmanagement.controller.user.admin.response.AdminResponse;
import com.project.taskmanagement.service.user.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/admins")
public class AdminController extends BaseController {
    private final AdminService adminService;

    @PostMapping
    public ResponseEntity<AdminResponse> createAdmin(@RequestBody CreateAdminRequest createAdminRequest){
        AdminResponse response = adminService.create(createAdminRequest);
        return answer(response,HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Void> updateAdmin(@RequestBody UpdateAdminRequest updateAdminRequest){
        adminService.update(updateAdminRequest);
        return answer(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<List<AdminResponse>> getAll(){
        List<AdminResponse> responses = adminService.getAll();
        return answer(responses,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AdminResponse> getByAdminId(@PathVariable int id){
        AdminResponse response = adminService.getById(id);
        return answer(response,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable int id){
        adminService.delete(id);
        return answer(HttpStatus.NO_CONTENT);
    }
}
