package com.project.taskmanagement.controller.authentication;

import com.project.taskmanagement.controller.BaseController;
import com.project.taskmanagement.controller.authentication.request.SignInRequest;
import com.project.taskmanagement.controller.authentication.request.SignUpRequest;
import com.project.taskmanagement.core.exception.AlreadyExistsException;
import com.project.taskmanagement.core.security.model.JwtToken;
import com.project.taskmanagement.service.auth.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController extends BaseController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@Valid @RequestBody SignUpRequest request) {
        try {
            authenticationService.signUp(request);
            return ResponseEntity.noContent().build();
        } catch (AlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getAlreadyExistsExceptionType().getMessage());
        }
    }

    @PostMapping("/signin")
    ResponseEntity<JwtToken> signIn(@Valid @RequestBody SignInRequest request) {
        JwtToken response = authenticationService.signIn(request);
        return answer(response, HttpStatus.OK);
    }

    @GetMapping("/isUserTrue")
    public ResponseEntity<Boolean> isCustomerTrue(
            @RequestParam String email, @RequestParam String password) {
        boolean response = authenticationService.isUserTrue(email, password);
        return answer(response, HttpStatus.OK);
    }
}
