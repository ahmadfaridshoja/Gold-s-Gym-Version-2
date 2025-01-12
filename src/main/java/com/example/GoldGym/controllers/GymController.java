package com.example.GoldGym.controllers;

import com.example.GoldGym.dto.GymDto;
import com.example.GoldGym.dto.UserDto;
import com.example.GoldGym.services.impl.GymService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<GymDto> getUserById(@PathVariable int id) {
        GymDto gymDto = gymService.getGymById(id);
        return ResponseEntity.ok(gymDto);
    }
    @GetMapping
    public ResponseEntity<List<GymDto>> getAllGyms() {
        List<GymDto> gyms = gymService.getAllGyms();
        return ResponseEntity.ok(gyms);
    }
    @PutMapping("/{id}")
    public ResponseEntity<GymDto> updateGymAllDataExceptId
            (@PathVariable int id, @RequestBody GymDto gymDto) {
        GymDto updatedGym = gymService.updateGymAllDataExceptId(id, gymDto.getManagerName(), gymDto.getAddress());
        return ResponseEntity.ok(updatedGym);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGym(@PathVariable int id) {
        String response = gymService.deleteGymById(id);
        return ResponseEntity.ok(response);
    }

}
