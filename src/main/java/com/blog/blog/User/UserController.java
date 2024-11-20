package com.blog.blog.User;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserResponseDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserResponseDto getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public UserResponseDto createUser(@RequestBody UserRequestDto requestDto){
        return userService.createUser(requestDto);
    }

    @PutMapping("/users/{id}")
    public UserResponseDto updateUser(@PathVariable int id, @RequestBody UserRequestDto requestDto){
        return userService.updateUser(id, requestDto);
    }

    @DeleteMapping("/users/{id}/{password}")
    public UserResponseDto deleteUser(@PathVariable int id, @PathVariable String password){
        return userService.deleteUser(id, password);
    }


}