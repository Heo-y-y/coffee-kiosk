package com.cafe.coffee.response;

import com.cafe.coffee.domain.Coffee;
import lombok.Getter;

@Getter
public class CoffeeCreateResponse {
    private String name;
    private int price;
}
