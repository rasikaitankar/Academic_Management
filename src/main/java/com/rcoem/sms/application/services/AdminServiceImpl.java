package com.rcoem.sms.application.services;

import com.rcoem.sms.application.dto.AdminDetails;
import com.rcoem.sms.application.mapper.AdminMapper;
import com.rcoem.sms.domain.entities.AdminInfo;
import com.rcoem.sms.domain.repositories.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    public AdminServiceImpl(AdminRepository adminRepository, AdminMapper adminMapper) {
        this.adminRepository = adminRepository;
        this.adminMapper = adminMapper;
    }

    @Override
    public List<AdminDetails> getAllAdmins() {
        return adminRepository.findAll().stream().map(adminMapper::toDto).toList();
    }

    @Override
    public AdminDetails createAdmin(AdminDetails adminDetails) {
        String uid = "ADMIN" + UUID.randomUUID();
        adminDetails.setId(uid);
        AdminInfo saved = adminRepository.save(adminMapper.toEntity(adminDetails));
        return adminMapper.toDto(saved);
    }

    @Override
    public AdminDetails getAdminById(String id) {
        Optional<AdminInfo> admin = adminRepository.findById(id);
        return admin.map(adminMapper::toDto).orElse(null);
    }

    @Override
    public AdminDetails updateAdminById(AdminDetails adminDetails) {
        if (!adminRepository.existsById(adminDetails.getId())) return null;
        AdminInfo updated = adminRepository.save(adminMapper.toEntity(adminDetails));
        return adminMapper.toDto(updated);
    }

    @Override
    public void deleteAdminById(String id) {
        adminRepository.deleteById(id);
    }
}
