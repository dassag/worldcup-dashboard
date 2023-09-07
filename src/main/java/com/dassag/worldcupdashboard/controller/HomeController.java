package com.dassag.worldcupdashboard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class HomeController {
    @RequestMapping("/")
    public ModelAndView frontend() {
        return new ModelAndView("index.html");
    }
}
