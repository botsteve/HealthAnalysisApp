package com.databaseProject.databaseProject.Mapper;

import com.databaseProject.databaseProject.Dto.*;
import com.databaseProject.databaseProject.Model.*;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDto fromEntityToDto(User user) {
        List<TempSensorDto> temperatures = user.getTemperatures().stream().map(e -> TempSensorMapper.fromEntityToDto(e)).collect(Collectors.toList());
        List<EKGDto> ekgs  = user.getEkgs().stream().map(e -> EKGMapper.fromEntityToDto(e)).collect(Collectors.toList());
        List<EMGDto> emgs = user.getEmgs().stream().map(e -> EMGMapper.fromEntityToDto(e)).collect(Collectors.toList());
        List<GPSDto> gps = user.getGps().stream().map(e -> GPSMapper.fromEntityToDto(e)).collect(Collectors.toList());
        return new UserDto(user.getEmail(),user.getFirstName(),user.getLastName(),user.getPassword(),user.getIsLogged(),user.getIsAdmin(),temperatures,ekgs,emgs,gps);
    }

    public static User fromDtoToEntity(UserDto userDto) {
        List<TempSensor> temperatures = userDto.getTemperatures().stream().map(e -> TempSensorMapper.fromDtoToEntity(e)).collect(Collectors.toList());
        List<EKG> ekgs  = userDto.getEkgs().stream().map(e -> EKGMapper.fromDtoToEntity(e)).collect(Collectors.toList());
        List<EMG> emgs = userDto.getEmgs().stream().map(e -> EMGMapper.fromDtoToEntity(e)).collect(Collectors.toList());
        List<GPS> gps = userDto.getGps().stream().map(e -> GPSMapper.fromDtoToEntity(e)).collect(Collectors.toList());
        return new User(userDto.getEmail(),userDto.getFirstName(),userDto.getLastName(),userDto.getPassword(),userDto.getIsLogged(),userDto.getIsAdmin(),temperatures,ekgs,emgs,gps);
    }
}
