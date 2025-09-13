package com.rcoem.sms.application.mapper;

import com.rcoem.sms.application.dto.TeacherDetails;
import com.rcoem.sms.domain.entities.TeacherInfo;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {
    public TeacherDetails toDto(TeacherInfo entity) {
        return TeacherDetails.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .department(entity.getDepartment())
                .specialization(entity.getSpecialization())
                .mobileNumber(entity.getMobileNumber())
                .build();
    }

    public TeacherInfo toEntity(TeacherDetails dto) {
        return TeacherInfo.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .department(dto.getDepartment())
                .specialization(dto.getSpecialization())
                .mobileNumber(dto.getMobileNumber())
                .build();
    }
}
