package by.it.academy.enterprise.pojo.strategy.one;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Dogs extends AnimalName {
    private String dogBreed;
    @ManyToOne
    private AnimalName animalName;
}
