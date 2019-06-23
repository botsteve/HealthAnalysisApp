package com.databaseProject.databaseProject.Controllers;

import com.databaseProject.databaseProject.Dto.EMGDto;
import com.databaseProject.databaseProject.Mapper.EMGMapper;
import com.databaseProject.databaseProject.Model.EMG;
import com.databaseProject.databaseProject.Model.User;
import com.databaseProject.databaseProject.Repositories.EMGRepository;
import com.databaseProject.databaseProject.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
@RequestMapping("/emg")
public class EMGController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EMGRepository emgRepository;

    @GetMapping
    public List<EMGDto> getEmgForUser() {
        List<EMG> listEmg = emgRepository.findAll().stream()
                .filter(e -> e.getUser().getIsLogged() == 1)
                .collect(Collectors.toList());
        return listEmg.stream().map(emg -> EMGMapper.fromEntityToDto(emg)).collect(Collectors.toList());
    }

    @PostMapping
    public EMGDto insertNewEMG(@RequestBody double voltageValue){
        User currentUser = new User();
        for (User user: userRepository.findAll()) {
            if (user.getIsLogged() == 1) {
                currentUser = user;
            }
        }
        EMG newEmg = new EMG(voltageValue, LocalDateTime.now(),currentUser);
        emgRepository.saveAndFlush(newEmg);
        return EMGMapper.fromEntityToDto(newEmg);
    }
}
