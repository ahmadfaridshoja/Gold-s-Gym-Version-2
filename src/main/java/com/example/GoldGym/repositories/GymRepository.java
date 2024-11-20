package com.example.GoldGym.repositories;

import com.example.GoldGym.models.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRepository extends JpaRepository<Gym, Integer> {
}
