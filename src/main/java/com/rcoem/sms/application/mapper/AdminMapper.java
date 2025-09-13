package com.rcoem.sms.application.mapper;

import com.rcoem.sms.application.dto.AdminDetails;
import com.rcoem.sms.domain.entities.AdminInfo;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {
    public AdminDetails toDto(AdminInfo entity) {
        return AdminDetails.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .role(entity.getRole())
                .password(entity.getPassword())
                .build();
    }

    public AdminInfo toEntity(AdminDetails dto) {
        return AdminInfo.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .role(dto.getRole())
                .password(dto.getPassword())
                .build();
    }
}
