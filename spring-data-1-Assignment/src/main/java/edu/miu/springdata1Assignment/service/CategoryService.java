package edu.miu.springdata1Assignment.service;

import edu.miu.springdata1Assignment.dto.CategoryDto;
import edu.miu.springdata1Assignment.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    public List<CategoryDto> findAll();
    public CategoryDto findById(int id);
    public void save(Category category);
    public void update(int id, Category category);
    public void delete(int id);
}
