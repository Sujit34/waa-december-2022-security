package edu.miu.springdata1Assignment.service.impl;

import edu.miu.springdata1Assignment.dto.ReviewDto;
import edu.miu.springdata1Assignment.entity.Review;
import edu.miu.springdata1Assignment.repository.ReviewRepo;
import edu.miu.springdata1Assignment.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<ReviewDto> findAll(){
        var reviews = (List<Review>) reviewRepo.findAll();
        return reviews.stream().map(x->modelMapper.map(x,ReviewDto.class)).toList();
    }
    @Override
    public ReviewDto findById(int id){
        var review = reviewRepo.findById(id);
        return modelMapper.map(review, ReviewDto.class);
    }
    @Override
    public void save(Review review){
        reviewRepo.save(review);
    }
    @Override
    public void update(int id, Review review){
        reviewRepo.findById(id).orElseThrow(() -> new RuntimeException("Review does not exists"));;
        reviewRepo.save(review);
    }
    @Override
    public void delete(int id){
        Review review = reviewRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Review does not exists"));
        reviewRepo.delete(review);
    }

}
