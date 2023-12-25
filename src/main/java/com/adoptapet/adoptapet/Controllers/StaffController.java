package com.adoptapet.adoptapet.Controllers;

import com.adoptapet.adoptapet.Dtos.StaffDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staffs")
public class StaffController {
    @GetMapping
    public ResponseEntity<String> getAllStaffs(){
        return new ResponseEntity<>("Staff", HttpStatus.OK);
    }

    @GetMapping("/{staffId}")
    public ResponseEntity<String> getStaff(@PathVariable int staffId){
        return new ResponseEntity<>("Staff", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addStaff(StaffDto staffDto){
        return new ResponseEntity<>("Staff added", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateStaff(StaffDto staffDto){
        return new ResponseEntity<>("Staff updated", HttpStatus.OK);
    }

    @DeleteMapping("/{staffId}")
    public ResponseEntity<String> deleteStaff(@PathVariable int staffId){
        return new ResponseEntity<>("Staff deleted", HttpStatus.OK);
    }
}
