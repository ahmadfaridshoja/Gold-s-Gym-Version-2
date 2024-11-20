package com.example.GoldGym.services.impl;

import com.example.GoldGym.dto.GymDto;
import com.example.GoldGym.dto.UserDto;
import com.example.GoldGym.models.Gym;

import java.util.List;

public interface GymService {
    GymDto createGym(GymDto gymDto);
    GymDto getGymById(int id);
    List<GymDto> getAllGyms();
    GymDto updateGymAllData(String ManagerName, String Address);
    String DeleteGymById(int id);

}
