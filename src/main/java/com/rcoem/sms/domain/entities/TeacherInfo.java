package com.rcoem.sms.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity(name = "teacher_info")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherInfo {
    @Id
    String id;
    String name;
    String email;
    String department;
    String specialization;
    String mobileNumber;
}