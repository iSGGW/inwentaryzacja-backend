package com.example.inwentaryzacjabackend.service.impl;

import com.example.inwentaryzacjabackend.exception.ResourceNotFoundException;
import com.example.inwentaryzacjabackend.model.Item;
import com.example.inwentaryzacjabackend.payload.ApiResponse;
import com.example.inwentaryzacjabackend.repository.ItemRepository;
import com.example.inwentaryzacjabackend.service.ItemService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

    // need to inject item dao
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item getItem(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item", "id", id));
    }

    @Override
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }


    // TO DO add user to the method
    @Override
    public ApiResponse deleteItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item", "id", id));
        // add delete method with permission check
        return null;
    }
}