package com.databaseProject.databaseProject.Mapper;

import com.databaseProject.databaseProject.Dto.EKGDto;
import com.databaseProject.databaseProject.Model.EKG;

public class EKGMapper {

    public static EKGDto fromEntityToDto(EKG ekg) {
        return new EKGDto(ekg.getVoltageValue(), ekg.getTimeValue());
    }

    public static EKG fromDtoToEntity(EKGDto ekgDto) {
        return new EKG(ekgDto.getVoltageValue(), ekgDto.getTimeValue());
    }
}
