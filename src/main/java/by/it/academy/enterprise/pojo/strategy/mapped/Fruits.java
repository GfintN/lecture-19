package by.it.academy.enterprise.pojo.strategy.mapped;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fruits extends ProductLifeTime{
    private String fruitName;

    @Override
    public String toString() {
        return "Fruits{" +
                "fruitName='" + fruitName + '\'' +
                '}';
    }
}
