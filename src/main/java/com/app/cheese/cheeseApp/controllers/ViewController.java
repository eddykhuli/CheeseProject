/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.cheese.cheeseApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
//     @RequestMapping("/")
//    public String index(){
//      
//        return "index";
//    }
//    
    @RequestMapping(path="/login")
    public String login()
    {
        return "login.html";
    }
//    @RequestMapping(path="/confirm")
//    public String confirm()
//    {
//        return "confirm";
//    }
//    
//    
}
