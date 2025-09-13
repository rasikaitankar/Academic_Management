package com.rcoem.sms.application.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AdminDetails {
    String id;
    String username;
    String email;
    String role;
    String password;
}
