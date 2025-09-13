package com.rcoem.sms.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity(name = "admin_info")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminInfo {
    @Id
    String id;
    String username;
    String email;
    String role;
    String password;
}
