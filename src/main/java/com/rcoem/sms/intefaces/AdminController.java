package com.rcoem.sms.intefaces;

import com.rcoem.sms.application.dto.AdminDetails;
import com.rcoem.sms.application.services.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public ResponseEntity<Void> addAdmin(@RequestBody AdminDetails adminDetails) {
        AdminDetails inserted = adminService.createAdmin(adminDetails);
        return ResponseEntity.created(URI.create("/admins/" + inserted.getId())).build();
    }

    @GetMapping
    public List<AdminDetails> getAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminDetails> getAdminById(@PathVariable String id) {
        AdminDetails details = adminService.getAdminById(id);
        return details == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(details);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminDetails> updateAdmin(@PathVariable String id, @RequestBody AdminDetails adminDetails) {
        adminDetails.setId(id);
        AdminDetails updated = adminService.updateAdminById(adminDetails);
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable String id) {
        adminService.deleteAdminById(id);
        return ResponseEntity.noContent().build();
    }
}