package com.example.demo.api;


import com.example.demo.dto.SubjectDto;
import com.example.demo.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/subject")
public class SubjectApi {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(subjectService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(subjectService.getById(id), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addSubject(@RequestBody SubjectDto subjectDto){
        subjectService.addSubject(subjectDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateSubject(@PathVariable(name = "id") Long id,
                                              @RequestBody SubjectDto subjectDto){
        subjectService.updateSubject(id, subjectDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable(name = "id") Long id){
        if(subjectService.deleteSubject(id)==true){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
