package com.medic.MainApp.Services.StatisticsServices;

import com.medic.MainApp.DTO.PatientsByGenderDto;
import com.medic.MainApp.DataMapper.StatisticsDataMapper.GenderDataMapper;

import java.util.List;

//@Component
public interface PatientStatisticsService {
    int getAllPatientCount();
    List<PatientsByGenderDto> getPatientCountByGender();
}
