package com.databaseProject.databaseProject.Mapper;

import com.databaseProject.databaseProject.Dto.EKGDto;
import com.databaseProject.databaseProject.Dto.EMGDto;
import com.databaseProject.databaseProject.Model.EKG;
import com.databaseProject.databaseProject.Model.EMG;

public class EMGMapper {
    public static EMG fromDtoToEntity(EMGDto emgDto){
        return new EMG(emgDto.getVoltageValue(),emgDto.getTimeValue());
    }

    public static EMGDto fromEntityToDto(EMG emg){
        return new EMGDto(emg.getVoltageValue(),emg.getTimeValue());
    }
}
