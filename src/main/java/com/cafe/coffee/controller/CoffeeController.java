package com.cafe.coffee.controller;

import com.cafe.coffee.response.CoffeeCreateResponse;
import com.cafe.coffee.response.CoffeeMenusResponse;
import com.cafe.coffee.response.CoffeeMenu;
import com.cafe.coffee.response.CoffeeUpdateResponse;
import com.cafe.coffee.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class CoffeeController {
    private final CoffeeService coffeeService;

    @PostMapping(value = "/post")
    public ResponseEntity<CoffeeMenu> sendNewCoffee(@RequestBody CoffeeCreateResponse coffeeCreateDto) {
        return ResponseEntity.ok(coffeeService.createCoffee(coffeeCreateDto));
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<CoffeeMenusResponse> sendCoffeeMenus() {
        return ResponseEntity.ok(coffeeService.findAllCoffees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoffeeMenu> sendCoffeeMenu(@PathVariable("id") Long id) {
        return ResponseEntity.ok(coffeeService.findCoffee(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CoffeeMenu> sendRevisedCoffee(@PathVariable("id") Long id,
                                                   @RequestBody CoffeeUpdateResponse coffeeUpdateDto) {
        return ResponseEntity.ok(coffeeService.updateCoffee(id, coffeeUpdateDto));
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
