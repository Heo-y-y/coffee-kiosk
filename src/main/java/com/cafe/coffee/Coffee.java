package com.cafe.coffee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Coffee {
    // AUTO = JPA 구현체에서 자동으로 적절한 생성 전략을 선택
    // IDENTITY = 데이터베이스에서 자동 증가 기능을 사용하여 primary key 값을 생성
    // SEQUENCE = 데이터베이스 시퀸스를 사용하여 primary key 값을 생성, 시퀸스는 일련번호를 생성하는 객체
    // TABLE = 데이터베이스 테이블을 사용하여 primary key 값을 생성, 시퀸스와 유사하게 일변번호를 생성하며, 특정 테이블을 생성하여 관리
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
}
