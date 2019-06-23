package com.databaseProject.databaseProject.Controllers;

import com.databaseProject.databaseProject.Dto.EKGDto;
import com.databaseProject.databaseProject.Dto.TempSensorDto;
import com.databaseProject.databaseProject.Mapper.EKGMapper;
import com.databaseProject.databaseProject.Mapper.TempSensorMapper;
import com.databaseProject.databaseProject.Model.EKG;
import com.databaseProject.databaseProject.Model.TempSensor;
import com.databaseProject.databaseProject.Model.User;
import com.databaseProject.databaseProject.Repositories.EKGRepository;
import com.databaseProject.databaseProject.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
@RequestMapping("/ekg")
public class EKGController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EKGRepository ekgRepository;

    @GetMapping
    public List<EKGDto> getEkgForUser() {
        List<EKG> listEkg = ekgRepository.findAll().stream()
                .filter(e -> e.getUser().getIsLogged() == 1)
                .collect(Collectors.toList());
        return listEkg.stream().map(ekg -> EKGMapper.fromEntityToDto(ekg)).collect(Collectors.toList());
    }

    @PostMapping
    public EKGDto insertNewEKG(@RequestBody double voltageValue){
        User currentUser = new User();
        for (User user: userRepository.findAll()) {
            if (user.getIsLogged() == 1) {
                currentUser = user;
            }
        }
        EKG newEkg = new EKG(voltageValue, LocalDateTime.now(),currentUser);
        ekgRepository.saveAndFlush(newEkg);
        return EKGMapper.fromEntityToDto(newEkg);
    }
}
