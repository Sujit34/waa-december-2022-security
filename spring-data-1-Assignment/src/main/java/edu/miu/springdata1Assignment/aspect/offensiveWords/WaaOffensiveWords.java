package edu.miu.springdata1Assignment.aspect.offensiveWords;

import edu.miu.springdata1Assignment.entity.User;
import jakarta.persistence.*;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaaOffensiveWords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int count;
    private LocalDateTime dateTime;
    @OneToOne
    private User user;
}
