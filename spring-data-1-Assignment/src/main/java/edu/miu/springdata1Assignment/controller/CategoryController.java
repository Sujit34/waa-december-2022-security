package edu.miu.springdata1Assignment.controller;

import edu.miu.springdata1Assignment.aspect.executionTime.ExecutionTime;
import edu.miu.springdata1Assignment.dto.CategoryDto;
import edu.miu.springdata1Assignment.entity.Category;
import edu.miu.springdata1Assignment.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping
    @ExecutionTime
    public List<CategoryDto> findAll(){
        return categoryService.findAll();
    }
    @GetMapping("/{id}")
    @ExecutionTime
    public CategoryDto findById(@PathVariable int id){
        return categoryService.findById(id);
    }
    @PostMapping
    @ExecutionTime
    public void save(Category category){
        categoryService.save(category);
    }
    @PutMapping("/{id}")
    @ExecutionTime
    public void update(@PathVariable int id, Category category){
        categoryService.update(id,category);
    }
    @DeleteMapping("/{id}")
    @ExecutionTime
    public void delete(@PathVariable int id){
        categoryService.delete(id);
    }
}
