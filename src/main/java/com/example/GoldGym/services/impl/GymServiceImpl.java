package com.example.GoldGym.services.impl;

import com.example.GoldGym.dto.GymDto;
import com.example.GoldGym.mapper.GymMapper;
import com.example.GoldGym.models.Gym;
import com.example.GoldGym.repositories.GymRepository;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GymServiceImpl implements GymService{
    @Autowired
    private GymRepository gymRepository;
    @Autowired
    private GymMapper gymMapper;


    @Override
    public GymDto createGym(GymDto gymDto) {
        Gym gym = gymMapper.mapToGym(gymDto);
        Gym savedGym = gymRepository.save(gym);
        return gymMapper.mapToGymDto(savedGym);
    }

    @Override
    public GymDto getGymById(int id) {
        return null;
    }

    @Override
    public List<GymDto> getAllGyms() {
        return List.of();
    }

    @Override
    public GymDto updateGymAllData(String ManagerName, String Address) {
        return null;
    }

    @Override
    public String DeleteGymById(int id) {
        return "";
    }
}
