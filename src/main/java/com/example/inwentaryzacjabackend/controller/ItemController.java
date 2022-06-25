package com.example.inwentaryzacjabackend.controller;

import com.example.inwentaryzacjabackend.model.Item;
import com.example.inwentaryzacjabackend.payload.ApiResponse;
import com.example.inwentaryzacjabackend.security.CurrentUser;
import com.example.inwentaryzacjabackend.security.UserPrincipal;
import com.example.inwentaryzacjabackend.service.ItemService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "https://20.218.104.224:8443", maxAge = 3600)
@RequestMapping("/api/items/")
@NoArgsConstructor
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable(name = "id") Long id) {
        return itemService.getItem(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@Valid @RequestBody Item item, @CurrentUser UserPrincipal currentUser) {
        return itemService.addItem(item, currentUser.getUsername());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable(name = "id") Long id, @Valid @RequestBody Item updatedItem, @CurrentUser UserPrincipal currentUser) {
        updatedItem.toString();
        return itemService.updateItem(id, updatedItem, currentUser.getUsername());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> deleteItem(@PathVariable(name = "id") Long id) {
        return itemService.deleteItem(id);
    }

    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        return itemService.getAllItems();
    }


}










