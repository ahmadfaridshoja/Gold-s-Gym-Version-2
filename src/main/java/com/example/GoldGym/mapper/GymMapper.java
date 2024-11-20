package com.example.GoldGym.mapper;

import com.example.GoldGym.dto.GymDto;
import com.example.GoldGym.models.Gym;

import org.springframework.stereotype.Component;
@Component
public class GymMapper {
    public Gym mapToGym(GymDto gymDto){
        return new Gym(
                gymDto.getId(),
                gymDto.getManagerName(),
                gymDto.getAddress()
        );
    }
    public GymDto mapToGymDto (Gym gym){
        return new GymDto(
                gym.getId(),
                gym.getManagerName(),
                gym.getAddress()
        );
    }
}
