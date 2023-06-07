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
@RequestMapping("api/versioningSample")
public class PersonController {

    /**
     * Bu ornekte API' nin URL' sine Versiyonu yazarak istek atilabilmesi secenegi icin orneklendirme yapilmistir.
     * */
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Alihaydar","Salman"));
    }
}
