package com.rcoem.sms.application.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseDetails {
    String id;
    String courseCode;
    String name;
    String description;
    int credits;
    String department;
}