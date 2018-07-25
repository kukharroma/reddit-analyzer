package co.sandbx.redditanalyzer.controller;

import co.sandbx.redditanalyzer.config.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private Env env;

    @GetMapping({"/", "/login"})
    public ModelAndView login() {
        ModelAndView model = new ModelAndView("login");
        model.addObject("authorize_url", env.getAuthorizeUrl());
        return model;
    }
}
