package com.cafe.coffee.controller.dto;

import com.cafe.coffee.domain.Coffee;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CoffeeResponseDto {
    private Long id;
    private String name;
    private int price;

    public static CoffeeResponseDto of(Coffee coffee) {

        CoffeeResponseDto coffeeResponseDto = new CoffeeResponseDto(
                coffee.getId(), coffee.getName(), coffee.getPrice());

        return coffeeResponseDto;
    }
}
