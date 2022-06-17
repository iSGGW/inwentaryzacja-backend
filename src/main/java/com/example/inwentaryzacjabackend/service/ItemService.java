package com.example.inwentaryzacjabackend.service;

import com.example.inwentaryzacjabackend.model.Item;
import com.example.inwentaryzacjabackend.payload.ApiResponse;

import java.util.List;

public interface ItemService {

    Item getItem(Long id);

    Item addItem(Item item);

    // TO DO add user to the method
    ApiResponse deleteItem(Long id);

    List<Item> getAllItemsByRoomId(Long roomId);
}