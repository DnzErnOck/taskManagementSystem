package com.project.taskmanagement.controller.user;

import com.project.taskmanagement.controller.BaseController;
import com.project.taskmanagement.controller.user.request.CreateUserRequest;
import com.project.taskmanagement.controller.user.request.UpdateUserRequest;
import com.project.taskmanagement.controller.user.response.UserResponse;
import com.project.taskmanagement.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController extends BaseController {
    private final UserService userService;
    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserRequest createUserRequest){
        userService.create(createUserRequest);
        return answer(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestBody UpdateUserRequest updateUserRequest){
        userService.update(updateUserRequest);
        return answer(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll(){
        List<UserResponse> responses = userService.getAll();
        return answer(responses,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getByUserId(@PathVariable int id){
        UserResponse response = userService.getById(id);
        return answer(response,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id){
        userService.delete(id);
        return answer(HttpStatus.NO_CONTENT);
    }
}
