package com.adoptapet.adoptapet.Controllers;

import com.adoptapet.adoptapet.Dtos.StaffDto;
import com.adoptapet.adoptapet.Entities.Staff.Staff;
import com.adoptapet.adoptapet.Services.StaffService;
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

    @GetMapping("/{shelterId}")
    public ResponseEntity<List<StaffDto>> getAllStaffs(@PathVariable int shelterId){
        List<StaffDto> staffDtos = staffService.getAllStaffs(shelterId);
        return new ResponseEntity<>(staffDtos, HttpStatus.OK);
    }

    @GetMapping("/{staffId}")
    public ResponseEntity<Staff> getStaff(@PathVariable int staffId){
        Staff staff = staffService.get(staffId);
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addStaff(StaffDto staffDto){
        staffService.add(staffDto);
        return new ResponseEntity<>("Staff added", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateStaff(StaffDto staffDto){
        staffService.update(staffDto);
        return new ResponseEntity<>("Staff updated", HttpStatus.OK);
    }

    @DeleteMapping("/{staffId}")
    public ResponseEntity<String> deleteStaff(@PathVariable int staffId){
        staffService.delete(staffId);
        return new ResponseEntity<>("Staff deleted", HttpStatus.OK);
    }
}
