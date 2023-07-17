package com.cafe.coffee.response;

import com.cafe.coffee.domain.Coffee;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CoffeeMenusResponse {
    private List<CoffeeMenu> CoffeeMenus;

    public static CoffeeMenusResponse of(List<Coffee> coffees) {
        return new CoffeeMenusResponse(coffees.stream().map(CoffeeMenu::of).collect(Collectors.toList()));
    }
}
