package edu.miu.springdata1Assignment.aspect.offensiveWords;

import edu.miu.springdata1Assignment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WaaOffensiveWordsRepository extends JpaRepository<WaaOffensiveWords, Integer> {
    Optional<WaaOffensiveWords> findByUser(User user);
}
