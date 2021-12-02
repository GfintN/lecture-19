package by.it.academy.enterprise.pojo.strategy.three;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Getter @Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Student extends Person{
    @Column(nullable = false)
    private String faculty;
}
