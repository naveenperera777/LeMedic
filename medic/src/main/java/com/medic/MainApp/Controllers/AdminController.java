package com.medic.MainApp.Controllers;

import com.medic.MainApp.Utils.ResponseUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@RestController
@RequestMapping("admin")
public class AdminController extends ResponseUtils {

    @GetMapping
    public void sendEmail(){
//        String recipient = "recipient@gmail.com";
//        String sender = "naveenperera777@gmail.com";
//        String host = "localhost";
//
//        Properties properties = System.getProperties();
//        properties.setProperty("mail.smtp.host", host);
//
//        Session session = Session.getDefaultInstance(properties);
//
//        try {
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(sender));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
//            message.addRecipients(Message.RecipientType.TO, new Address[...]); // email to multiple recipients
//            message.setSubject("Hello World!");
//            message.setText("And hello from the body of the message!");
//
//            Transport.send(message);
//
//        } catch (AddressException e) {
//            e.printStackTrace();
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
                  // Sender's email ID needs to be mentioned
            String from = "";
            String pass ="";
            String to = "";

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
                message.setSubject("This is the Subject Line!");

                // Now set the actual message
                message.setText("This is actual message");

                // Send message
                Transport transport = session.getTransport("smtp");
                transport.connect(host, from, pass);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
                System.out.println("Sent message successfully....");
            }catch (MessagingException mex) {
                mex.printStackTrace();
            }

}}
