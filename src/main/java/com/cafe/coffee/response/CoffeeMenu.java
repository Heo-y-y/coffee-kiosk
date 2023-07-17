package com.cafe.coffee.response;

import com.cafe.coffee.domain.Coffee;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CoffeeMenu {
    private long id;
    private String name;
    private int price;

    public static CoffeeMenu of(Coffee coffee) {
        return new CoffeeMenu(coffee.getId(), coffee.getName(), coffee.getPrice());
    }
}
