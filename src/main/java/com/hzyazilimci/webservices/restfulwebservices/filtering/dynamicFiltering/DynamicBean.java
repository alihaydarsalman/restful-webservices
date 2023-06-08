package com.hzyazilimci.webservices.restfulwebservices.filtering.dynamicFiltering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author hzyazilimci
 */

@Getter
@AllArgsConstructor
@JsonFilter("SomeBeanFilter")
public class DynamicBean {

    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String password;
    private int age;
}
