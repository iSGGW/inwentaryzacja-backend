package com.example.inwentaryzacjabackend.service;

import com.example.inwentaryzacjabackend.model.Floor;

// response entity vs pojo, to be decided

public interface FloorService {

    Floor getFloor(Long id);

    Floor addFloor(Floor floor);

}
