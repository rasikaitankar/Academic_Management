package com.rcoem.sms.application.services;

import com.rcoem.sms.application.dto.AdminDetails;
import java.util.List;

public interface AdminService {
    List<AdminDetails> getAllAdmins();
    AdminDetails createAdmin(AdminDetails adminDetails);
    AdminDetails getAdminById(String id);
    AdminDetails updateAdminById(AdminDetails adminDetails);
    void deleteAdminById(String id);
}
