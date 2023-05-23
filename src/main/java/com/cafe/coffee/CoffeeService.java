package com.cafe.coffee;

import com.cafe.coffee.dto.CoffeeCreateDto;
import com.cafe.coffee.dto.CoffeeResponseDto;
import com.cafe.coffee.dto.CoffeeResponseDtoList;
import com.cafe.coffee.dto.CoffeeUpdateDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

// of 메서드 활용하기
@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;
    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }
    public CoffeeResponseDto createCoffee(CoffeeCreateDto coffeeCreateDto) {

        Coffee coffee = new Coffee();
        coffee.setName(coffeeCreateDto.getName());
        coffee.setPrice(coffeeCreateDto.getPrice());

        coffeeRepository.save(coffee);

//        CoffeeResponseDto coffeeResponseDto = coffeeToResponseDto(coffee);
        CoffeeResponseDto coffeeResponseDto = CoffeeResponseDto.of(coffee);

        return coffeeResponseDto;
    }
    public CoffeeResponseDtoList findCoffeeList() {
        List<Coffee> coffees = coffeeRepository.findAll();
        return CoffeeResponseDtoList.of(coffees);

//        CoffeeResponseDtoList coffeeResponseDtoList = new CoffeeResponseDtoList();
//        List<CoffeeResponseDto> coffeeResponseDtoLists = new ArrayList<>();
//        List<Coffee> coffees = new ArrayList<>();
//        coffees.addAll(coffeeRepository.findAll());
//        for (int i = 0; i < coffees.size(); i++) {
//            Coffee coffee = coffees.get(i);
//            CoffeeResponseDto coffeeResponseDto = CoffeeResponseDto.of(coffee);
//            coffeeResponseDtoLists.add(coffeeResponseDto);
//        }
//        coffeeResponseDtoList.setCoffeeResponseDtoList(coffeeResponseDtoLists);
//        return coffeeResponseDtoList;
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

// 반복 메서드
    private Coffee getCoffee(Long id) {
        Coffee coffee = coffeeRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return coffee;
    }
// 외부에서 수정할 수 있는 코드
//    private CoffeeResponseDto coffeeToResponseDto(Coffee coffee) {
//        CoffeeResponseDto coffeeResponseDto = new CoffeeResponseDto();
//        coffeeResponseDto.setId(coffee.getId());
//        coffeeResponseDto.setName(coffee.getName());
//        coffeeResponseDto.setPrice(coffee.getPrice());
//        return coffeeResponseDto;
//    }
}
