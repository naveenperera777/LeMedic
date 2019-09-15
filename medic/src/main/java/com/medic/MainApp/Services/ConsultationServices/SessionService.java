package com.medic.MainApp.Services.ConsultationServices;

import com.medic.MainApp.DAO.ConsultationDAO.SessionDAO;
import com.medic.MainApp.Models.ConsultationModels.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    private final SessionDAO sessionDAO;
    private static final Logger logger = LoggerFactory.getLogger(SessionService.class);

    public SessionService(SessionDAO sessionDAO){
        this.sessionDAO = sessionDAO;
    }

    public void setSession(Session session){
            sessionDAO.setSesssion(session);
    }

}
