package com.databaseProject.databaseProject.Controllers;

import com.databaseProject.databaseProject.Dto.GPSDto;
import com.databaseProject.databaseProject.Mapper.GPSMapper;
import com.databaseProject.databaseProject.Model.GPS;
import com.databaseProject.databaseProject.Model.User;
import com.databaseProject.databaseProject.Repositories.GPSRepository;
import com.databaseProject.databaseProject.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
@RequestMapping("/gps")
public class GPSController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GPSRepository gpsRepository;

    @GetMapping
    public List<GPSDto> getGpsLocationForUser() {
        List<GPS> listGps = gpsRepository.findAll().stream()
                .filter(e -> e.getUser().getIsLogged() == 1)
                .collect(Collectors.toList());
        return listGps.stream().map(gps -> GPSMapper.fromEntityToDto(gps)).collect(Collectors.toList());
    }

    @PostMapping
    public GPSDto insertNewGPSLocation(@RequestBody GPSDto gpsDto){
        User currentUser = new User();
        for (User user: userRepository.findAll()) {
            if (user.getIsLogged() == 1) {
                currentUser = user;
            }
        }
        GPS newGps = new GPS(gpsDto.getLatitude(),gpsDto.getLongitude(),gpsDto.getAltitude(),LocalDateTime.now(),currentUser);
        gpsRepository.saveAndFlush(newGps);
        return GPSMapper.fromEntityToDto(newGps);
    }
}
