package com.example.inwentaryzacjabackend.controller;

import com.example.inwentaryzacjabackend.model.Item;
import com.example.inwentaryzacjabackend.payload.ApiResponse;
import com.example.inwentaryzacjabackend.service.ItemService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
/**
 *Klasa ItemController kontroluje infromacje o przedmiotach
 */
@CrossOrigin(origins = "https://20.218.104.224:8443", maxAge = 3600)
@RequestMapping("/api/items/")
@NoArgsConstructor
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;
    /**
     *Klasa getItem umożlwia podgląd przedmiotów
     * @return Zwraca informacje o wybranym przedmiocie
     */
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable(name = "id") Long id) {
        return itemService.getItem(id);
    }
    /**
     *Klasa addItem umożlwia dodanie informacji o przedmiocie
     * @return Zwraca informację o dodaniu nowego przedmiotu
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@Valid @RequestBody Item item) {
        return itemService.addItem(item);
    }
    /**
     *Klasa updateItem umożlwia aktualizację informacji o przedmiocie
     * @return Zwraca informację o aktualizacji danych
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable(name = "id") Long id, @Valid @RequestBody Item updatedItem) {
        return itemService.updateItem(id, updatedItem);
    }
    /**
     *Klasa deleteItem umożlwia usunięcie dodanego przedmiotu
     * @return Zwraca informację o usunięciu przedmiotu
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> deleteItem(@PathVariable(name = "id") Long id) {
        return itemService.deleteItem(id);
    }
    /**
     *Klasa getAllItems umożlwia podgląd wszystkich przedmiotów
     * @return Zwraca listę istniejących przedmiotów
     */
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        return itemService.getAllItems();
    }


}










