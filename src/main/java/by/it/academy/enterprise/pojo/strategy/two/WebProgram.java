package by.it.academy.enterprise.pojo.strategy.two;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@NoArgsConstructor
@DiscriminatorValue("Web")
public class WebProgram extends ProgramAuthor{
    private String webProgramName;
}
