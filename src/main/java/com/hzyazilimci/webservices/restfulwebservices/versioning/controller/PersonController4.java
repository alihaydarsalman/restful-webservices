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
@RequestMapping("api/versionWithAcceptHeader")
public class PersonController4 {

    @GetMapping(path = "/person", produces = "application/hzyazilimci.co.app-v1+json")
    public PersonV1 getFirstVersionOfPersonWithAcceptHeader(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person", produces = "application/hzyazilimci.co.app-v2+json")
    public PersonV2 getSecondVersionOfPersonWithAcceptHeader(){
        return new PersonV2(new Name("Alihaydar","Salman"));
    }

    @GetMapping(path = "/person", produces = "application/hzyazilimci.co.app-v2+xml")
    public PersonV2 getSecondVersionOfPersonWithAcceptHeaderXML(){
        return new PersonV2(new Name("Alihaydar","Salman"));
    }
}
