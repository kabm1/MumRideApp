package com.mum.ride.controller;

import com.mum.ride.model.Person;
import com.mum.ride.model.UserDetail;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
public class TestController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String welcome(UserDetail userDetail){
        return "login";
    }
    @PostMapping(value ="/login")
    public String logginngin(@Valid UserDetail userDetail, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            System.out.println("Failing");
            return "login";

        }
        else{
            System.out.print("Successful");
            return "index";
        }
    }
    @GetMapping("/register")
    public String vewRegiser(Person person){
            return "registerPage";
    }

    @PostMapping("/register")
        public String registerUser(@Valid Person person, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "registerPage";

        }

        return "redirect:/index";
    }

}
