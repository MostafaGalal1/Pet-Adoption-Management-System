package com.adoptapet.adoptapet.Controllers;


import com.adoptapet.adoptapet.Dtos.AdminDto;
import com.adoptapet.adoptapet.Services.EntityServices.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public ResponseEntity<List<AdminDto>> getAllAdmins() {
        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    @GetMapping("/{adminId}")
    public ResponseEntity<AdminDto> getAdmin(@PathVariable int adminId) {
        return ResponseEntity.ok(adminService.getAdmin(adminId));
    }

    @PostMapping
    public ResponseEntity<String> addAdmin(@RequestBody AdminDto adminDto) {
        adminService.addAdmin(adminDto);
        return ResponseEntity.ok("Admin added successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateAdmin(@RequestBody AdminDto adminDto) {
        adminService.updateAdmin(adminDto);
        return ResponseEntity.ok("Admin updated successfully");
    }

    @DeleteMapping("/{adminId}")
    public ResponseEntity<String> deleteAdmin(@PathVariable int adminId) {
        adminService.deleteAdmin(adminId);
        return ResponseEntity.ok("Admin deleted successfully");
    }
}
