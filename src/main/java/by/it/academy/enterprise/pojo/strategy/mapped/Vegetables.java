package by.it.academy.enterprise.pojo.strategy.mapped;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vegetables extends ProductLifeTime{
    private String vegetablesName;

    @Override
    public String toString() {
        return "Vegetables{" +
                "vegetablesName='" + vegetablesName + '\'' +
                '}';
    }
}
