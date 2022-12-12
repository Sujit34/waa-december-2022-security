package edu.miu.springdata1Assignment.service.impl;

import edu.miu.springdata1Assignment.dto.CategoryDto;
import edu.miu.springdata1Assignment.entity.Category;
import edu.miu.springdata1Assignment.repository.CategoryRepo;
import edu.miu.springdata1Assignment.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<CategoryDto> findAll(){
        var categories = (List<Category>) categoryRepo.findAll();
        return categories.stream().map(x->modelMapper.map(x, CategoryDto.class)).toList();
    }
    @Override
    public CategoryDto findById(int id){
        var category = categoryRepo.findById(id);
        return modelMapper.map(category, CategoryDto.class);
    }
    @Override
    public void save(Category category){
        categoryRepo.save(category);
    }
    @Override
    public void update(int id, Category category){
        categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category does not exists"));;
        categoryRepo.save(category);
    }
    @Override
    public void delete(int id){
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category does not exists"));
        categoryRepo.delete(category);
    }
}
