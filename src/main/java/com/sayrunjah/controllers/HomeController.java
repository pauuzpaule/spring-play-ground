package com.sayrunjah.controllers;

import com.sayrunjah.lib.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.getModelMap().put("name", "Sayrunjah Pauuz");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public ModelAndView viewLogin() {
        return new ModelAndView("user/login");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("email", request.getParameter("email"));
        return "redirect:/welcome";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/welcome")
    public ModelAndView welcome(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("user/welcome");
        modelAndView.getModelMap().put("email", request.getParameter("email"));
        return modelAndView;
    }

    @RequestMapping("/hello")
    public String getHelloMessage() {
        return "Hello Sayrunjah Pauuz!!!!";
    }
}
