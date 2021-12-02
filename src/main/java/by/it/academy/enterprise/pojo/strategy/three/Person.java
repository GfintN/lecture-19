package by.it.academy.enterprise.pojo.strategy.three;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue
    private Long personId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String surName;
}
