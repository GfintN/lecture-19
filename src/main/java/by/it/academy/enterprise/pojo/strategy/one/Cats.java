package by.it.academy.enterprise.pojo.strategy.one;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Cats extends AnimalName {
    private String catBreed;
}
