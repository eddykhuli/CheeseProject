/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.cheese.cheeseApp.controllers;

import com.app.cheese.cheeseApp.domain.VerificationToken;
import com.app.cheese.cheeseApp.entities.Role;
import com.app.cheese.cheeseApp.entities.User;
import com.app.cheese.cheeseApp.repositories.UserRepository;
import com.app.cheese.cheeseApp.repositories.VerificationTokenRepository;
import com.app.cheese.cheeseApp.services.EmailService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "/api/user/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailService emailSenderService;

//      @RequestMapping(value="/register", method = RequestMethod.GET)
//    public ModelAndView displayRegistration(ModelAndView modelAndView, User user)
//    {
//        modelAndView.addObject("user", user);
//        modelAndView.setViewName("register");
//        return modelAndView;
//    }
//    
//     @RequestMapping(value="/register", method = RequestMethod.POST)
//    public ModelAndView registerUser( ModelAndView modelAndView,User user)
//    {
//        
//        User existingUser = userRepository.findByEmail(user.getEmail());
//        if(existingUser != null)
//        {
//              modelAndView.addObject("message","This email already exists!");
//              modelAndView.setViewName("error.html");
//        
//            return modelAndView;
//        }
//        else
//        {
//          
//            user.setRole(new Role("USER"));
//            user.setUsername(user.getFirst_name()+""+user.getLast_name());
//            userRepository.save(user);
//
//            VerificationToken verificationToken = new VerificationToken(user);
//
//            confirmationTokenRepository.save(verificationToken);
//
//            SimpleMailMessage mailMessage = new SimpleMailMessage();
//            mailMessage.setTo(user.getEmail());
//            mailMessage.setSubject("Complete Registration!");
//            mailMessage.setFrom("eddykthobela@gmail.com");
//            mailMessage.setText("To confirm your account, please click here : "
//            +"http://localhost:8888/confirm-account?token="+verificationToken.getVerificationToken());
//
//            emailSenderService.sendEmail(mailMessage);
//            
//            modelAndView.addObject("email", user.getEmail());
//
//            modelAndView.setViewName("successfulRegisteration");
//        }
//
//        return modelAndView;
//    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User registerUser(@RequestBody User user) {
        String message = "";
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            message = "Error : This email already exists!";
            return user;
        } else {

            user.setRole(new Role("USER"));
            user.setUsername(user.getFirst_name() + "" + user.getLast_name());
            userRepository.save(user);

            VerificationToken verificationToken = new VerificationToken(user);

            confirmationTokenRepository.save(verificationToken);
//
//            SimpleMailMessage mailMessage = new SimpleMailMessage();
//            mailMessage.setTo(user.getEmail());
//            mailMessage.setSubject("Complete Registration!");
//            mailMessage.setFrom("eddykthobela@gmail.com");
//            mailMessage.setText("To confirm your account, please click here : "
//            +"http://localhost:8888/confirm-account?token="+verificationToken.getVerificationToken());
//
//            emailSenderService.sendEmail(mailMessage);
//            
            message = "successfulRegisteration";

        }

        return user;
    }

    @RequestMapping(value = "/confirm-account", method = {RequestMethod.GET, RequestMethod.POST})
    public String confirmUserAccount(@RequestParam("token") String verificationToken) {
        String message = "";
        VerificationToken token = confirmationTokenRepository.findByVerificationToken(verificationToken);

        if (token != null) {
            User user = userRepository.findByEmail(token.getUser().getEmail());
            user.setEnabled(true);
            userRepository.save(user);
            message = "Successfully Registered User";
        } else {
            message = "Error : The link is invalid or broken!";

        }

        return message;
    }

    @RequestMapping(value = "/validateLogin", method = RequestMethod.GET)
    public User validateLogin(@RequestParam String email) {
        User foundUser = userRepository.findByEmail(email);

        return foundUser;
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public Principal getUser(Principal user) {
       
        return user;
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        List<User> people = new ArrayList<>();
        userRepository.findAll().forEach(people::add);
        return people;
    }

}
