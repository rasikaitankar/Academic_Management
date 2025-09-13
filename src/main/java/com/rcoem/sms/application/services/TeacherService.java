package com.rcoem.sms.application.services;

import com.rcoem.sms.application.dto.TeacherDetails;
import java.util.List;

public interface TeacherService {
    List<TeacherDetails> getAllTeachers();
    TeacherDetails createTeacher(TeacherDetails teacherDetails);
    TeacherDetails getTeacherById(String id);
    TeacherDetails updateTeacherById(TeacherDetails teacherDetails);
    void deleteTeacherById(String id);
}
