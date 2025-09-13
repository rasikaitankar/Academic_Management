package com.rcoem.sms.application.mapper;

import com.rcoem.sms.application.dto.CourseDetails;
import com.rcoem.sms.domain.entities.CourseInfo;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    public CourseDetails toDto(CourseInfo entity) {
        return CourseDetails.builder()
                .id(entity.getId())
                .courseCode(entity.getCourseCode())
                .name(entity.getName())
                .description(entity.getDescription())
                .credits(entity.getCredits())
                .department(entity.getDepartment())
                .build();
    }

    public CourseInfo toEntity(CourseDetails dto) {
        return CourseInfo.builder()
                .id(dto.getId())
                .courseCode(dto.getCourseCode())
                .name(dto.getName())
                .description(dto.getDescription())
                .credits(dto.getCredits())
                .department(dto.getDepartment())
                .build();
    }
}
