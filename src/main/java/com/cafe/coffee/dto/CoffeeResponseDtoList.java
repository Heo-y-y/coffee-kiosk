package com.cafe.coffee.dto;

import com.cafe.coffee.Coffee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class CoffeeResponseDtoList {

    private List<CoffeeResponseDto> coffeeResponseDtoList;

    public static CoffeeResponseDtoList of(List<Coffee> coffees) {
        List<CoffeeResponseDto> coffeeResponseDtoList = new ArrayList<>();
        for (int i = 0; i < coffees.size(); i++) {
            Coffee coffee = coffees.get(i);
            CoffeeResponseDto coffeeResponseDto = CoffeeResponseDto.of(coffee);
            coffeeResponseDtoList.add(coffeeResponseDto);
        }

        CoffeeResponseDtoList coffeeResponseDtoLists = new CoffeeResponseDtoList();
        coffeeResponseDtoLists.setCoffeeResponseDtoList(coffeeResponseDtoList);

        return coffeeResponseDtoLists;
    }
}
