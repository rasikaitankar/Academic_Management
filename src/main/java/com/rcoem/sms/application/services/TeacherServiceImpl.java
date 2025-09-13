package com.rcoem.sms.application.services;

import com.rcoem.sms.application.dto.TeacherDetails;
import com.rcoem.sms.application.mapper.TeacherMapper;
import com.rcoem.sms.domain.entities.TeacherInfo;
import com.rcoem.sms.domain.repositories.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public TeacherServiceImpl(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    @Override
    public List<TeacherDetails> getAllTeachers() {
        return teacherRepository.findAll().stream().map(teacherMapper::toDto).toList();
    }

    @Override
    public TeacherDetails createTeacher(TeacherDetails teacherDetails) {
        String uid = "TEACHER" + UUID.randomUUID();
        teacherDetails.setId(uid);
        TeacherInfo saved = teacherRepository.save(teacherMapper.toEntity(teacherDetails));
        return teacherMapper.toDto(saved);
    }

    @Override
    public TeacherDetails getTeacherById(String id) {
        Optional<TeacherInfo> teacher = teacherRepository.findById(id);
        return teacher.map(teacherMapper::toDto).orElse(null);
    }

    @Override
    public TeacherDetails updateTeacherById(TeacherDetails teacherDetails) {
        if (!teacherRepository.existsById(teacherDetails.getId())) return null;
        TeacherInfo updated = teacherRepository.save(teacherMapper.toEntity(teacherDetails));
        return teacherMapper.toDto(updated);
    }

    @Override
    public void deleteTeacherById(String id) {
        teacherRepository.deleteById(id);
    }
}
