package com.medic.MainApp.Controllers;
import com.medic.MainApp.DTO.EmailDto;
import com.medic.MainApp.Services.AdminService;
import com.medic.MainApp.Utils.EnvConfig;
import com.medic.MainApp.Utils.ResponseUtils;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@RestController
@RequestMapping("admin")
public class AdminController extends ResponseUtils {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/email")
    public void sendEmail(@RequestBody EmailDto emailDto){
    adminService.sendEmail(emailDto);
}
}
