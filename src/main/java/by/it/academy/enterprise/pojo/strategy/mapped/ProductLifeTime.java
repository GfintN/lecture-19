package by.it.academy.enterprise.pojo.strategy.mapped;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductLifeTime{
    @Id
    @GeneratedValue
    private Long id;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate dateCreate;
    @Column(updatable = false)
    private LocalDate shelfLife;

}
