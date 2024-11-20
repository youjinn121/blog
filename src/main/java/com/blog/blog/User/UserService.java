package com.blog.blog.User;

import com.blog.blog.User.UserDomain;
import com.blog.blog.User.UserResponseDto;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserResponseDto(user))
                .collect(Collectors.toList());
    }

    public UserResponseDto getUserById(int id) {
        UserDomain user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        return new UserResponseDto(user);
    }

    public UserResponseDto createUser(UserRequestDto requestDto) {
        UserDomain user = UserDomain.builder()
                .userName(requestDto.getUserName())
                .userPassword(requestDto.getUserPassword())
                .email(requestDto.getEmail())
                .build();

        UserDomain savedUser = userRepository.save(user);
        return new UserResponseDto(savedUser);
    }


    public UserResponseDto updateUser(int id, UserRequestDto requestDto) {
        UserDomain existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));

        UserDomain updatedUser = UserDomain.builder()
                .userId(existingUser.getUserId())
                .userName(requestDto.getUserName())
                .userPassword(requestDto.getUserPassword())
                .email(requestDto.getEmail())
                .build();

        UserDomain savedUser = userRepository.save(updatedUser);
        return new UserResponseDto(savedUser);
    }

    public UserResponseDto deleteUser(int id, String password) {
        UserDomain user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));

        if (!user.getUserPassword().equals(password)) {
            throw new IllegalArgumentException("Password does not match.");
        }

        userRepository.deleteById(id);
        return new UserResponseDto(user);
    }
}