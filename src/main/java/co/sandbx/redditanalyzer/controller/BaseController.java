package co.sandbx.redditanalyzer.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {

    @GetMapping("/{resource}")
    public ModelAndView data(@PathVariable("resource") String resource) {
        ModelAndView model = new ModelAndView(resource);
        model.addObject("nav", resource);
        return model;
    }
}
