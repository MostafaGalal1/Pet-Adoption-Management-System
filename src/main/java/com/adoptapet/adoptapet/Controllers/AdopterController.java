package com.adoptapet.adoptapet.Controllers;
import com.adoptapet.adoptapet.Dtos.AdopterDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adopters")
public class AdopterController {

    @GetMapping
    public ResponseEntity<String> getAllAdopters() {
        return null;
    }

    @GetMapping("/{adopterId}")
    public ResponseEntity<String> getAdopter(@PathVariable int adopterId) {
        return null;
    }

    @PostMapping
    public ResponseEntity<String> addAdopter(@RequestBody AdopterDto adopterDto) {
        return null;
    }

    @PutMapping
    public ResponseEntity<String> updateAdopter(@RequestBody AdopterDto adopterDto) {
        return null;
    }

    @DeleteMapping("/{adopterId}")
    public ResponseEntity<String> deleteAdopter(@PathVariable int adopterId) {
        return null;
    }
}

