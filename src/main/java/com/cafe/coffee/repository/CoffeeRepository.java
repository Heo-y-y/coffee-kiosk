package com.cafe.coffee.repository;

import com.cafe.coffee.domain.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    @Query("SELECT c FROM Coffee c WHERE c.id = :id")
    Coffee findCoffeeById(Long id);
}
