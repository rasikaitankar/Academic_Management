package com.rcoem.sms.application.services;

import com.rcoem.sms.application.dto.CourseDetails;
import com.rcoem.sms.application.mapper.CourseMapper;
import com.rcoem.sms.domain.entities.CourseInfo;
import com.rcoem.sms.domain.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public List<CourseDetails> getAllCourses() {
        return courseRepository.findAll().stream().map(courseMapper::toDto).toList();
    }

    @Override
    public CourseDetails createCourse(CourseDetails courseDetails) {
        String uid = "COURSE" + UUID.randomUUID();
        courseDetails.setId(uid);
        CourseInfo saved = courseRepository.save(courseMapper.toEntity(courseDetails));
        return courseMapper.toDto(saved);
    }

    @Override
    public CourseDetails getCourseById(String id) {
        Optional<CourseInfo> course = courseRepository.findById(id);
        return course.map(courseMapper::toDto).orElse(null);
    }

    @Override
    public CourseDetails updateCourseById(CourseDetails courseDetails) {
        if (!courseRepository.existsById(courseDetails.getId())) return null;
        CourseInfo updated = courseRepository.save(courseMapper.toEntity(courseDetails));
        return courseMapper.toDto(updated);
    }

    @Override
    public void deleteCourseById(String id) {
        courseRepository.deleteById(id);
    }
}
