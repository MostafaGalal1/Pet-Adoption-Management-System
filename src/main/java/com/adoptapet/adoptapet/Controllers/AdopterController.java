package com.adoptapet.adoptapet.Controllers;
import com.adoptapet.adoptapet.Dtos.AdopterDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/adopter/")
@RestController
public class AdopterController {

    @PostMapping("add")
    public ResponseEntity<String> add(AdopterDto adopterDto) {
        return null;
    }
}
