package com.cafe.coffee.dto;

import com.cafe.coffee.Coffee;
import lombok.*;

@Getter
@Setter
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CoffeeResponseDto {
    private Long id;
    private String name;
    private int price;

    // 내부에서 관리하는 코드 of
    public static CoffeeResponseDto of(Coffee coffee) {
        // No
//        CoffeeResponseDto coffeeResponseDto = new CoffeeResponseDto();
//        coffeeResponseDto.setId(coffee.getId());
//        coffeeResponseDto.setName(coffee.getName());
//        coffeeResponseDto.setPrice(coffee.getPrice());
        // All
        CoffeeResponseDto coffeeResponseDto = new CoffeeResponseDto(coffee.getId(), coffee.getName(), coffee.getPrice());

        return coffeeResponseDto;
    }
}
