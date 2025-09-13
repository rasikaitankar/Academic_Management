package com.rcoem.sms.application.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TeacherDetails {
    String id;
    String name;
    String email;
    String department;
    String specialization;
    String mobileNumber;
}
