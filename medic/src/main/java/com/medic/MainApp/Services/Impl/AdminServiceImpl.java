package com.medic.MainApp.Services.Impl;

import com.medic.MainApp.DTO.EmailDto;
import com.medic.MainApp.Services.AdminService;
import com.medic.MainApp.Utils.EnvConfig;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class AdminServiceImpl implements AdminService {
    @Override
    public void sendEmail(EmailDto emailDto) {

        String from = EnvConfig.ADMIN_EMAIL;
        String pass = EnvConfig.ADMIN_PASSWORD;
        String to = emailDto.getReceiver();

        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.starttls.required", "true");
        properties.put("mail.smtp.startssl.enable", "true");
        properties.put("mail.smtp.startssl.required", "true");
        properties.put("mail.smtp.debug", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", from);
        properties.put("mail.smtp.password", pass);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try{
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(emailDto.getTitle());

            message.setContent("<h1>"+emailDto.getTitle()+"</h1>"+
                    "<h1>Diagnosis</h1>"+
                    "<p>Complain : "+ emailDto.getDiagnosis().getComplain() + "</p>" +
                    "<p>Signs : "+  emailDto.getDiagnosis().getSigns() + "</p>" +
                    "<p>Investigation : "+  emailDto.getDiagnosis().getInvestigation() + "</p>" +
                    "<p>General Examination : "+  emailDto.getDiagnosis().getGeneral_exam() + "</p>" +
                    "<p>Systemic Examination : "+  emailDto.getDiagnosis().getSystem_exam() + "</p>"+
                    "<h1>Medication</h1>"+
                    "<p>Medical Management : "+  emailDto.getMedication().getMedical_management() + "</p>" +
                    "<p>Surgical Management : "+ emailDto.getMedication().getSurgical_management() + "</p>" +
                    "<p>Specail Remarks  : "+ emailDto.getMedication().getRemarks() + "</p>" +
                    "<p>Next visit date : "+  emailDto.getMedication().getNext_date() + "</p>" +
                    "<h1>Pricing</h1>"+
                    "<p>Consultation Fees : "+  emailDto.getPricing().getConsultationFees() + "</p>" +
                    "<p>Medications Fees : "+  emailDto.getPricing().getMedicationFees() + "</p>" +
                    "<p>Miscellaneous Charges : "+  emailDto.getPricing().getMiscellaneous() + "</p>" +
                    "<p>Total Amount : "+   emailDto.getPricing().getTotal() + "</p>"
                    ,
                    "text/html");

            // Send message
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
