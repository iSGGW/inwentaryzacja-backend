package com.example.inwentaryzacjabackend.service;

import com.example.inwentaryzacjabackend.model.Item;
import com.example.inwentaryzacjabackend.payload.ApiResponse;

public interface ItemService {

    Item getItem(Long id);

    Item addItem(Item item);

    // TO DO add user to the method
    ApiResponse deleteItem(Long id);

}