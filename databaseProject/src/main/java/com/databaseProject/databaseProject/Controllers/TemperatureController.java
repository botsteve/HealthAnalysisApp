package com.databaseProject.databaseProject.Controllers;

import com.databaseProject.databaseProject.CONSTANT;
import com.databaseProject.databaseProject.Dto.TempSensorDto;
import com.databaseProject.databaseProject.Dto.UserDto;
import com.databaseProject.databaseProject.Mapper.TempSensorMapper;
import com.databaseProject.databaseProject.Mapper.UserMapper;
import com.databaseProject.databaseProject.Model.TempSensor;
import com.databaseProject.databaseProject.Model.User;
import com.databaseProject.databaseProject.Repositories.TempSensorRepository;
import com.databaseProject.databaseProject.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins= CONSTANT.API_ENDPOINT, allowedHeaders="*")
@RequestMapping("/temperature")
public class TemperatureController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TempSensorRepository tempSensorRepository;

    @GetMapping
    public List<TempSensorDto> getTemperatureForUser() {
        List<TempSensor> listTemperatures = tempSensorRepository.findAll().stream()
                .filter(e -> e.getUser().getIsLogged() == 1)
                .collect(Collectors.toList());
        return listTemperatures.stream().map(tempSensor -> TempSensorMapper.fromEntityToDto(tempSensor)).collect(Collectors.toList());
    }

    @PostMapping
    public TempSensorDto insertNewTemp(@RequestBody double tempValue){
        User currentUser = new User();
        for (User user: userRepository.findAll()) {
            if (user.getIsLogged() == 1) {
                currentUser = user;
            }
        }
        TempSensor newTemp = new TempSensor(tempValue, LocalDateTime.now(),currentUser);
        tempSensorRepository.saveAndFlush(newTemp);
        return TempSensorMapper.fromEntityToDto(newTemp);
    }
}
