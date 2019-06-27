package com.databaseProject.databaseProject.Controllers;

import com.databaseProject.databaseProject.Dto.UserDto;
import com.databaseProject.databaseProject.Mapper.UserMapper;
import com.databaseProject.databaseProject.Model.User;
import com.databaseProject.databaseProject.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    private boolean searchUserByEmail(List<UserDto> users, UserDto searchedUser) {
        for (UserDto user : users) {
            if (user.getEmail().equals(searchedUser.getEmail())) {
                return true;
            }
        }

        return false;
    }

    @GetMapping
    public List<UserDto> getUsers() {

        return userRepository.findAll().stream().map(e -> UserMapper.fromEntityToDto(e)).collect(Collectors.toList());
    }

    @GetMapping("/loggedUser")
    public UserDto getLoggedUser() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getIsLogged() == 1) {
                return UserMapper.fromEntityToDto(user);
            }
        }

        return null;
    }

    @DeleteMapping("/delete")
    @Transactional
    public void deleteUser(@RequestParam(value="email") String email) {
        userRepository.deleteByEmail(email);
    }

    @GetMapping("/emails")
    public UserDto getUserByEmail(@RequestParam(value="email") String email) {
        if(userRepository.findByEmail(email) == null){
            return null;
        }
        return UserMapper.fromEntityToDto(userRepository.findByEmail(email));
    }

    @PostMapping
    @ResponseBody
    public UserDto createUser(@RequestBody UserDto userDto) {
        List<User> users = userRepository.findAll();
        List<UserDto> usersDto = new ArrayList<>();
        for (User user : users) {
            usersDto.add(UserMapper.fromEntityToDto(user));
        }

        if (searchUserByEmail(usersDto, userDto)) {
            return null;
        }
        userRepository.save(UserMapper.fromDtoToEntity(userDto));
        return userDto;
    }

    @PutMapping("/user")
    @Transactional
    public UserDto updateUserLoggedIn(@RequestBody String email){
        User user = userRepository.findByEmail(email);
        user = userRepository.getOne(user.getId());
        user.setIsLogged(1);
        userRepository.save(user);
        return UserMapper.fromEntityToDto(user);
    }

    @PutMapping("/userLoggingOut")
    @Transactional
    public UserDto updateUserLoggingOut(){
        List<User> users = userRepository.findAll();
        User updatedUser = new User();
        for (User user : users) {
            if (user.getIsLogged() == 1) {
                updatedUser = user;
            }
        }
        updatedUser.setIsLogged(0);
        updatedUser = userRepository.getOne(updatedUser.getId());
        userRepository.saveAndFlush(updatedUser);
        return UserMapper.fromEntityToDto(updatedUser);
    }

    @PostMapping("/register")
    @Transactional
    public UserDto regiserUser(@RequestBody UserDto userDto) {
        User newUser = UserMapper.fromDtoToEntity(userDto);

        userRepository.saveAndFlush(newUser);
        return userDto;
    }

}