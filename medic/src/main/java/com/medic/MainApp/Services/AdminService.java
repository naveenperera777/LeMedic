package com.medic.MainApp.Services;

import com.medic.MainApp.DTO.EmailDto;

public interface AdminService {
    void sendEmail(EmailDto emailDto);
}
