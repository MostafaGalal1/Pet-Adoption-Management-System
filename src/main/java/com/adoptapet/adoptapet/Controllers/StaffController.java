package com.adoptapet.adoptapet.Controllers;

import com.adoptapet.adoptapet.Dtos.StaffDto;
import com.adoptapet.adoptapet.Entities.Staff.Staff;
import com.adoptapet.adoptapet.Services.EntityServices.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController {
    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public ResponseEntity<List<StaffDto>> getAllStaffs(){
        return ResponseEntity.ok(staffService.getAllStaffs());
    }

    @GetMapping("/shelter/{shelterId}")
    public ResponseEntity<List<StaffDto>> getAllStaffs(@PathVariable int shelterId){
        return ResponseEntity.ok(staffService.getAllStaffByShelterId(shelterId));
    }

    @GetMapping("/{staffId}")
    public ResponseEntity<Staff> getStaff(@PathVariable int staffId){
        return ResponseEntity.ok(staffService.getStaff(staffId));
    }

    @PostMapping
    public ResponseEntity<String> addStaff(@RequestBody StaffDto staffDto){
        staffService.addStaff(staffDto);
        return ResponseEntity.ok("Staff added successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateStaff(@RequestBody StaffDto staffDto){
        staffService.updateStaff(staffDto);
        return ResponseEntity.ok("Staff updated successfully");
    }

    @DeleteMapping("/{staffId}")
    public ResponseEntity<String> deleteStaff(@PathVariable int staffId){
        staffService.deleteStaff(staffId);
        return ResponseEntity.ok("Staff deleted successfully");
    }
}
