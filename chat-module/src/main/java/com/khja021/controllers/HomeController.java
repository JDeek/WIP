package com.khja021.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */
@Controller
public class HomeController {
    @RequestMapping(value="/")
    public String index(){
        return "static/index.html";
    }
}
