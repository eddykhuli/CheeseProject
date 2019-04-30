/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.cheese.cheeseApp.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Reverside
 */
@RestController
public class EmailController {
//     @PreAuthorize("hasAnyRole('ADMIN')") 
    @RequestMapping(value="/sendEmail")
    public String sendEmail() throws AddressException, MessagingException, IOException {
        
        sendmail();
        return "Email Sent";
    }
    
    private void sendmail() throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");      
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");



      Session session = Session.getInstance(props, new javax.mail.Authenticator() {
         @Override
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("eddykthobela@gmail.com", "khulile7");
         }
        
      });
       session.getProperties().put("mail.smtp.ssl.trust", "smtp.gmail.com");
       session.getProperties().put("mail.smtp.starttls.enable", "true");
        Message msg = new MimeMessage(session);
      msg.setFrom(new InternetAddress("eddykthobela@gmail.com", false));

      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("eddykthobela@gmail.com"));
      msg.setSubject("Message from System");
      msg.setContent("Message from System", "text/html");
      msg.setSentDate(new Date());

      MimeBodyPart messageBodyPart = new MimeBodyPart();
      messageBodyPart.setContent("Just Checking if this application is working...!!!", "text/html");

      Multipart multipart = new MimeMultipart();
      multipart.addBodyPart(messageBodyPart);
//      MimeBodyPart attachPart = new MimeBodyPart();
//
//      attachPart.attachFile("/var/tmp/image19.png");
//      multipart.addBodyPart(attachPart);
      msg.setContent(multipart);
      Transport.send(msg);  
        System.out.println("ASentt");

    }
    
}
