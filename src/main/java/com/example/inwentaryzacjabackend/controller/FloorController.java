package com.example.inwentaryzacjabackend.controller;

import com.example.inwentaryzacjabackend.model.Floor;
import com.example.inwentaryzacjabackend.service.FloorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@NoArgsConstructor
@RestController
public class FloorController {

    @Autowired
    private FloorService floorService;

    @RequestMapping("/floor/{id}")
    public ResponseEntity<Floor> getFloor(@PathVariable(name = "id") Long id) {
        Floor floor = floorService.getFloor(id);

        return new ResponseEntity< >(floor, HttpStatus.OK);
    }

}
