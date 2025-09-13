package com.rcoem.sms.application.services;

import com.rcoem.sms.application.dto.CourseDetails;
import java.util.List;

public interface CourseService {
    List<CourseDetails> getAllCourses();
    CourseDetails createCourse(CourseDetails courseDetails);
    CourseDetails getCourseById(String id);
    CourseDetails updateCourseById(CourseDetails courseDetails);
    void deleteCourseById(String id);
}
