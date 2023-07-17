package com.cafe.coffee.service;

import com.cafe.coffee.domain.Coffee;
import com.cafe.coffee.response.CoffeeMenusResponse;
import com.cafe.coffee.repository.CoffeeRepository;
import com.cafe.coffee.response.CoffeeCreateResponse;
import com.cafe.coffee.response.CoffeeMenu;
import com.cafe.coffee.response.CoffeeUpdateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Service
public class CoffeeService {
    private final CoffeeRepository coffeeRepository;

    public CoffeeMenu createCoffee(CoffeeCreateResponse coffeeCreate) {
        Coffee newCoffee = coffeeRepository.save(new Coffee(coffeeCreate.getName(), coffeeCreate.getPrice()));
        return CoffeeMenu.of(newCoffee);
    }

    public CoffeeMenusResponse findAllCoffees() {
        return CoffeeMenusResponse.of(coffeeRepository.findAll());
    }

    public CoffeeMenu findCoffee(Long id) {
        if (coffeeRepository.findCoffeeById(id) == null) throw new EntityNotFoundException("해당 CoffeeId가 없습니다.");
        return CoffeeMenu.of(coffeeRepository.findCoffeeById(id));
    }

    @Transactional
    public CoffeeMenu updateCoffee(Long id, CoffeeUpdateResponse coffeeUpdate) {
        if (coffeeRepository.findCoffeeById(id) == null) throw new EntityNotFoundException("해당 CoffeeId가 없습니다.");
        if (coffeeUpdate.getName() != null) {
            coffeeRepository.findCoffeeById(id).setName(coffeeUpdate.getName());
        }
        if (coffeeUpdate.getPrice() != 0) {
            coffeeRepository.findCoffeeById(id).setPrice(coffeeUpdate.getPrice());
        }
        return CoffeeMenu.of(coffeeRepository.findCoffeeById(id));
    }

    public void deleteCoffee(Long id) {
        if (coffeeRepository.findCoffeeById(id) == null) throw new EntityNotFoundException("해당 CoffeeId가 없습니다.");
        coffeeRepository.deleteById(id);
    }

    public void deleteCoffees() {
        coffeeRepository.deleteAll();
    }
}
