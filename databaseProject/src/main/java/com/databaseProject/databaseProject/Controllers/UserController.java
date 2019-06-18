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
    public List<User> getUsers() {
        return userRepository.findAll();
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
    public User createUser(@RequestBody UserDto userDto) {

        List<User> users = userRepository.findAll();
        List<UserDto> usersDto = new ArrayList<>();
        for (User user : users) {
            usersDto.add(UserMapper.fromEntityToDto(user));
        }

        if (searchUserByEmail(usersDto, userDto)) {
            return null;
        }

        return userRepository.save(UserMapper.fromDtoToEntity(userDto));
    }

    @PutMapping
    public User updateUserLoggedIn(@RequestParam String email){
        User user = userRepository.findByEmail(email);
        user = userRepository.getOne(user.getId());
        user.setIsLogged(1);
        userRepository.save(user);
        return user;
    }

}