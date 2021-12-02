package by.it.academy.enterprise.pojo.strategy.two;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PROGRAM_TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Author")
public class ProgramAuthor {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String surName;
    private String osProgramName;
    private String webProgramName;
}
