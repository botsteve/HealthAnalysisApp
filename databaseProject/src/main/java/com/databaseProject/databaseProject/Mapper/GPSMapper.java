package com.databaseProject.databaseProject.Mapper;

import com.databaseProject.databaseProject.Dto.GPSDto;
import com.databaseProject.databaseProject.Model.GPS;

public class GPSMapper {

    public static GPSDto fromEntityToDto(GPS gps) {
        return new GPSDto(gps.getLatitude(),gps.getLongitude(),gps.getAltitude());
    }

    public static GPS fromDtoToEntity(GPSDto gpsDto) {
        return new GPS(gpsDto.getLatitude(),gpsDto.getLongitude(),gpsDto.getAltitude());
    }
}
