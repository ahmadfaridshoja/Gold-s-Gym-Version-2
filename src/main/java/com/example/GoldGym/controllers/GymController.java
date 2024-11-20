package com.example.GoldGym.controllers;

import com.example.GoldGym.dto.GymDto;
import com.example.GoldGym.services.impl.GymService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gyms")
public class GymController {
    private GymService gymService;
    public GymController(GymService gymService){
        this.gymService = gymService;
    }
    @PostMapping
    public ResponseEntity<GymDto> addGym(@RequestBody GymDto gymDto){
        return new ResponseEntity<>(gymService.createGym(gymDto), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<GymDto> getGymById(@PathVariable int id) {
        GymDto gymDto = gymService.getGymById(id);
        return ResponseEntity.ok(gymDto);
    }
}
