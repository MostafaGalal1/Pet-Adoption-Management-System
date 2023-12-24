package com.adoptapet.adoptapet.Controllers;

import com.adoptapet.adoptapet.Dtos.StaffDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/staff/")
@RestController
public class StaffController {

    @PostMapping("add")
    public ResponseEntity<String > addStaff(StaffDto staffDto){
        return new ResponseEntity<>("Staff added", HttpStatus.OK);
    }
}
