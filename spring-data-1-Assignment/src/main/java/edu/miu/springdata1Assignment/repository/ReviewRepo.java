package edu.miu.springdata1Assignment.repository;

import edu.miu.springdata1Assignment.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends CrudRepository<Review,Integer> {
    List<Review> findByProduct_Id(int id);
}
