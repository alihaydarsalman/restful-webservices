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
@RequestMapping("api/versionWithHeaderSample")
public class PersonController3 {

    @GetMapping(path = "/person", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonWithHeader(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonWithHeader(){
        return new PersonV2(new Name("Alihaydar","Salman"));
    }
}