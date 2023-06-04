package com.hzyazilimci.webservices.restfulwebservices.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hzyazilimci
 */
@RestController
public class BaseController {


    @RequestMapping(method = RequestMethod.GET, path = "/api/welcome")
    public String welcome(){
        return "Welcome";
    }
}
