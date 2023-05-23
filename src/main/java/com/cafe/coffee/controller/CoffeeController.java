package com.cafe.coffee.controller;

import com.cafe.coffee.dto.CoffeeCreateDto;
import com.cafe.coffee.dto.CoffeeResponseDto;
import com.cafe.coffee.dto.CoffeeResponseDtoList;
import com.cafe.coffee.dto.CoffeeUpdateDto;
import com.cafe.coffee.service.CoffeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CoffeeController {

    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @PostMapping
    public ResponseEntity<CoffeeResponseDto> createCoffee(@RequestBody CoffeeCreateDto coffeeCreateDto) {
        CoffeeResponseDto coffeeResponseDto = coffeeService.createCoffee(coffeeCreateDto);
        return ResponseEntity.ok(coffeeResponseDto);
    }

    @GetMapping
    public ResponseEntity<CoffeeResponseDtoList> getCoffeeList() {
        CoffeeResponseDtoList coffeeResponseDtoList = coffeeService.findCoffeeList();
        return ResponseEntity.ok(coffeeResponseDtoList);
    }
// @PathVariable 만 쓰지마! 숙제
    @GetMapping("/{id}")
    public ResponseEntity<CoffeeResponseDto> getCoffee(@PathVariable("id") Long id) {
        CoffeeResponseDto coffeeResponseDto = coffeeService.findCoffee(id);
        return ResponseEntity.ok(coffeeResponseDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CoffeeResponseDto> updateCoffee(@PathVariable("id") Long id,
                                                          @RequestBody CoffeeUpdateDto coffeeUpdateDto) {
        CoffeeResponseDto coffeeResponseDto = coffeeService.updateCoffee(id, coffeeUpdateDto);
        return ResponseEntity.ok(coffeeResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoffee(@PathVariable("id") Long id) {
        coffeeService.deleteCoffee(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCoffees() {
        coffeeService.deleteCoffees();
        return ResponseEntity.noContent().build();
    }
}
