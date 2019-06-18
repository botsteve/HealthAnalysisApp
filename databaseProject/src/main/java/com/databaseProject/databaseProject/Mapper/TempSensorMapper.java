package com.databaseProject.databaseProject.Mapper;

import com.databaseProject.databaseProject.Dto.TempSensorDto;
import com.databaseProject.databaseProject.Model.TempSensor;

public class TempSensorMapper {
    public static TempSensorDto fromEntityToDto(TempSensor tempSensor) {
        return new TempSensorDto(tempSensor.getTempValue(),tempSensor.getTimeValue());
    }

    public static TempSensor fromDtoToEntity(TempSensorDto tempSensorDto) {
        return new TempSensor(tempSensorDto.getTempValue(),tempSensorDto.getTimeValue());
    }
}
