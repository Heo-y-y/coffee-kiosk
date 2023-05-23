package com.cafe.coffee.service;

import com.cafe.coffee.domain.Coffee;
import com.cafe.coffee.repository.CoffeeRepository;
import com.cafe.coffee.controller.dto.CoffeeCreateDto;
import com.cafe.coffee.controller.dto.CoffeeResponseDto;
import com.cafe.coffee.controller.dto.CoffeeResponseDtoList;
import com.cafe.coffee.controller.dto.CoffeeUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    public CoffeeResponseDto createCoffee(CoffeeCreateDto coffeeCreateDto) {

        Coffee coffee = new Coffee();
        coffee.setName(coffeeCreateDto.getName());
        coffee.setPrice(coffeeCreateDto.getPrice());

        coffeeRepository.save(coffee);

        CoffeeResponseDto coffeeResponseDto = CoffeeResponseDto.of(coffee);

        return coffeeResponseDto;
    }
    public CoffeeResponseDtoList findCoffeeList() {
        List<Coffee> coffees = coffeeRepository.findAll();
        return CoffeeResponseDtoList.of(coffees);

    }

    public CoffeeResponseDto findCoffee(Long id) {
        Coffee coffee = getCoffee(id);
        CoffeeResponseDto coffeeResponseDto = CoffeeResponseDto.of(coffee);
        return coffeeResponseDto;
    }

    @Transactional
    public CoffeeResponseDto updateCoffee(Long id, CoffeeUpdateDto coffeeUpdateDto) {
        Coffee coffee = getCoffee(id);

        if (coffeeUpdateDto.getName() != null) {
            coffee.setName(coffeeUpdateDto.getName());
        }
        if (coffeeUpdateDto.getPrice() != 0) {
            coffee.setPrice(coffeeUpdateDto.getPrice());
        }

        CoffeeResponseDto coffeeResponseDto = CoffeeResponseDto.of(coffee);
        return coffeeResponseDto;
    }

    public void deleteCoffee(Long id) {
        coffeeRepository.deleteById(id);
    }

    public void deleteCoffees() {
        coffeeRepository.deleteAll();
    }

    private Coffee getCoffee(Long id) {
        Coffee coffee = coffeeRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return coffee;
    }
}
