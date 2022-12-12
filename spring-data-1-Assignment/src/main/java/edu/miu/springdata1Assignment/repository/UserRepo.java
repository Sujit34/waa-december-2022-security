package edu.miu.springdata1Assignment.repository;

import edu.miu.springdata1Assignment.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User,Integer> {
    User findByEmail(String email);
}
