package com.sayrunjah.lib;

import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

public class Util {

    public static ModelAndView view(String viewPath, HashMap<?, ?> passedData) {
       ModelAndView modelAndView = new ModelAndView(viewPath);
       modelAndView.getModel().put("data", passedData);
       return modelAndView;
    }
}
