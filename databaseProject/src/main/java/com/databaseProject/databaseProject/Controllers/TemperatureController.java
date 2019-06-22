package com.databaseProject.databaseProject.Controllers;

import com.databaseProject.databaseProject.Dto.TempSensorDto;
import com.databaseProject.databaseProject.Dto.UserDto;
import com.databaseProject.databaseProject.Mapper.TempSensorMapper;
import com.databaseProject.databaseProject.Model.TempSensor;
import com.databaseProject.databaseProject.Repositories.TempSensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
@RequestMapping("/temperature")
public class TemperatureController {

    @Autowired
    private TempSensorRepository tempSensorRepository;

    @GetMapping
    public List<TempSensorDto> getTemperatureForUser() {
        List<TempSensor> listTemperatures = tempSensorRepository.findAll().stream()
                .filter(e -> e.getUser().getIsLogged() == 1)
                .collect(Collectors.toList());
        return listTemperatures.stream().map(tempSensor -> TempSensorMapper.fromEntityToDto(tempSensor)).collect(Collectors.toList());
    }
}
