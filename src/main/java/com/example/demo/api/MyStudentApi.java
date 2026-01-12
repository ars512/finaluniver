package com.example.demo.api;

import com.example.demo.models.Student;
import com.example.demo.service.MyStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class MyStudentApi {
    public final MyStudentService myStudentService;

    @PostMapping("/registr")
    public void registr(@RequestBody Student student){
        myStudentService.registr(student);}

    @GetMapping("/check")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<?> getAll(){return ResponseEntity.ok("You are authorized!");}
}
