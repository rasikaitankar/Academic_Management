package com.rcoem.sms.intefaces;

import com.rcoem.sms.application.dto.CourseDetails;
import com.rcoem.sms.application.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<Void> addCourse(@RequestBody CourseDetails courseDetails) {
        CourseDetails inserted = courseService.createCourse(courseDetails);
        return ResponseEntity.created(URI.create("/courses/" + inserted.getId())).build();
    }

    @GetMapping
    public List<CourseDetails> getCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDetails> getCourseById(@PathVariable String id) {
        CourseDetails details = courseService.getCourseById(id);
        return details == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(details);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDetails> updateCourse(@PathVariable String id, @RequestBody CourseDetails courseDetails) {
        courseDetails.setId(id);
        CourseDetails updated = courseService.updateCourseById(courseDetails);
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String id) {
        courseService.deleteCourseById(id);
        return ResponseEntity.noContent().build();
    }
}

