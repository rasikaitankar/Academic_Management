package com.rcoem.sms.intefaces;

import com.rcoem.sms.application.dto.StudentDetails;
import com.rcoem.sms.application.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {
    private final StudentService studentService;

    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }
//    @Autowired
//    StudentService studentService;

    @PostMapping
    public ResponseEntity<Void> addStudent(@RequestBody StudentDetails studentDetails) {
        StudentDetails insertedStudentDetails=studentService.createStudent(studentDetails);
        return ResponseEntity.created(URI.create("/students/"+insertedStudentDetails.getId())).build();
    }
    @GetMapping
    public List<StudentDetails> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDetails> getStudentById( @PathVariable String id) {
        StudentDetails studentDetails= studentService.getStudentById(id);
        if(studentDetails==null){
          return  ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(studentDetails);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentDetails> updateStudent(@RequestBody StudentDetails studentDetails) {
        StudentDetails updatedStudentDetails = studentService.updateStudentById(studentDetails);
        if (updatedStudentDetails == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedStudentDetails);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable String id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

}
