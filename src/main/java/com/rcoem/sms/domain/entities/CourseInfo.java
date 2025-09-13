
package com.rcoem.sms.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity(name = "course_info")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseInfo {
    @Id
    String id;
    String courseCode;
    String name;
    String description;
    int credits;
    String department;
}