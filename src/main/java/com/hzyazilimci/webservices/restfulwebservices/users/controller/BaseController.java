package com.hzyazilimci.webservices.restfulwebservices.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * @author hzyazilimci
 */

@RequiredArgsConstructor
@RestController
public class BaseController {

    private final MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET, path = "/welcome")
    public String welcome(){
        return "Welcome";
    }

    @GetMapping("/greetingWithI18N")
    public String greetingWithI18N(){

        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "DEFAULT MESSAGE FOR THIS METHOD", locale);
    }
}
