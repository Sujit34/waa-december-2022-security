package edu.miu.springdata1Assignment.service;

import edu.miu.springdata1Assignment.dto.ReviewDto;
import edu.miu.springdata1Assignment.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    public List<ReviewDto> findAll();
    public ReviewDto findById(int id);
    public void save(Review review);
    public void update(int id, Review review);
    public void delete(int id);

}
