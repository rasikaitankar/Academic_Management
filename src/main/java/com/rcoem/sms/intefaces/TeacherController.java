package com.rcoem.sms.intefaces;

import com.rcoem.sms.application.dto.TeacherDetails;
import com.rcoem.sms.application.services.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<Void> addTeacher(@RequestBody TeacherDetails teacherDetails) {
        TeacherDetails inserted = teacherService.createTeacher(teacherDetails);
        return ResponseEntity.created(URI.create("/teachers/" + inserted.getId())).build();
    }

    @GetMapping
    public List<TeacherDetails> getTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDetails> getTeacherById(@PathVariable String id) {
        TeacherDetails details = teacherService.getTeacherById(id);
        return details == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(details);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherDetails> updateTeacher(@PathVariable String id, @RequestBody TeacherDetails teacherDetails) {
        teacherDetails.setId(id);
        TeacherDetails updated = teacherService.updateTeacherById(teacherDetails);
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable String id) {
        teacherService.deleteTeacherById(id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<TeacherDetails> patchTeacher(
            @PathVariable String id,
            @RequestBody Map<String, Object> updates) {

        TeacherDetails existing = teacherService.getTeacherById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        // Apply only provided updates
        updates.forEach((field, value) -> {
            switch (field) {
                case "name" -> existing.setName((String) value);
                case "email" -> existing.setEmail((String) value);
                case "department" -> existing.setDepartment((String) value);
                case "specialization" -> existing.setSpecialization((String) value);
                case "mobileNumber" -> existing.setMobileNumber((String) value);
            }
        });

        TeacherDetails updated = teacherService.updateTeacherById(existing);
        return ResponseEntity.ok(updated);
    }

}
