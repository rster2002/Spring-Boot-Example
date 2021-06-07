package com.me.demo.controllers;

import com.me.demo.DTOs.LoginDTO;
import com.me.demo.services.LegoEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    LegoEmployeeService legoEmployeeService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody LoginDTO login) {
        return legoEmployeeService.login(login.getUsername(), login.getPassword());
    }
}
