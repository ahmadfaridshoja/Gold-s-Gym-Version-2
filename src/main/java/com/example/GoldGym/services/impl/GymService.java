package com.example.GoldGym.services.impl;

import com.example.GoldGym.dto.GymDto;

import java.util.List;

public interface GymService {
    GymDto createGym(GymDto gymDto);
    GymDto getGymById(int id);
    List<GymDto> getAllGyms();
    String deleteGymById(int id);

    GymDto updateGymAllDataExceptId(int id, String managerName, String address);
}

