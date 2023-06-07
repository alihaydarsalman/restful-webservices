package com.hzyazilimci.webservices.restfulwebservices.versioning.controller;

import com.hzyazilimci.webservices.restfulwebservices.versioning.entity.Name;
import com.hzyazilimci.webservices.restfulwebservices.versioning.entity.PersonV1;
import com.hzyazilimci.webservices.restfulwebservices.versioning.entity.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hzyazilimci
 */

@RestController
@RequestMapping("api/versionWithParameterValue")
public class PersonController2 {

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonWithParameterValue(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonWithParameterValue(){
        return new PersonV2(new Name("Alihaydar","Salman"));
    }
}
