package org.launchcode.HomeBartender.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CreateUserController {
    @RequestMapping(value = "register")
    @ResponseBody
    public String index() {
        return "register";
    }

    //    need to code to display form
    @GetMapping("register")
    public String renderFormMethodName(Model model) {
//model.addAttribute("login", )
        // Method code...

        return "register";
    }

    @GetMapping("create")
    public String renderCreateUserForm() {
        return "create user";
    }
}


