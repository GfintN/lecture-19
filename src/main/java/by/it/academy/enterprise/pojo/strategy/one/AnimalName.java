package by.it.academy.enterprise.pojo.strategy.one;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AnimalName {
    @Id
    private Long id;
    private String name;
}
