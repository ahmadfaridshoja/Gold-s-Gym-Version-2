package com.example.GoldGym.services.impl;

import com.example.GoldGym.dto.GymDto;
import com.example.GoldGym.mapper.GymMapper;
import com.example.GoldGym.models.Gym;
import com.example.GoldGym.repositories.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public GymDto getGymById(int id){
        Gym gym = gymRepository.findById((int) id)
                .orElseThrow(() -> new RuntimeException("Error finding the gym"));
        return gymMapper.mapToGymDto(gym);
    }

    @Override
    public List<GymDto> getAllGyms(){
        List<Gym> gyms = gymRepository.findAll();
        List<GymDto> gymDtos = gyms.stream().map(gymMapper::mapToGymDto).collect(Collectors.toList());

        return gymDtos;
    }

    @Override
    public String deleteGymById(int id) {
        if (gymRepository.existsById(id)) {
            gymRepository.deleteById(id);
            return "deleted"+id;
        } else {
            return "no record found";
        }
    }
    @Override
    public GymDto updateGymAllDataExceptId(int id, String managerName, String address) {
        Gym gym = gymRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error finding the gym with id: " + id));

        gym.setManagerName(managerName);
        gym.setAddress(address);
        Gym updatedGym = gymRepository.save(gym);

        return gymMapper.mapToGymDto(updatedGym);
    }

}
