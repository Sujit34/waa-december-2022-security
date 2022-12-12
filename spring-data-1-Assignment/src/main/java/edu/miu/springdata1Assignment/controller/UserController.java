package edu.miu.springdata1Assignment.controller;

import edu.miu.springdata1Assignment.aspect.executionTime.ExecutionTime;
import edu.miu.springdata1Assignment.dto.UserDto;
import edu.miu.springdata1Assignment.entity.User;
import edu.miu.springdata1Assignment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private UserService userService;

    @GetMapping
    @ExecutionTime
    public List<UserDto> findAll(){
        return userService.findAll();
    }
    @GetMapping("/{id}")
    @ExecutionTime
    public UserDto findById(@PathVariable int id){
        return userService.findById(id);
    }
    @PostMapping
    @ExecutionTime
    public void save(User user){
        userService.save(user);
    }
    @PutMapping("/{id}")
    @ExecutionTime
    public void update(@PathVariable int id, User user){
        userService.update(id,user);
    }
    @DeleteMapping("/{id}")
    @ExecutionTime
    public void delete(@PathVariable int id){
        userService.delete(id);
    }
}
