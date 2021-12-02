package by.it.academy.enterprise.pojo.strategy.two;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@NoArgsConstructor
@DiscriminatorValue("Os")
public class OsProgram extends ProgramAuthor{
    private String osProgramName;
}
