package com.example.GoldGym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GymDto {
    private int id;
    private String managerName;
    private String address;
}
