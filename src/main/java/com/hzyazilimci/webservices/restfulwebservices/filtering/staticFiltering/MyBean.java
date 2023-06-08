package com.hzyazilimci.webservices.restfulwebservices.filtering.staticFiltering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author hzyazilimci
 */

@Getter
@AllArgsConstructor
@JsonIgnoreProperties({"age","first_name"})
public class MyBean {

    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonIgnore
    private String password;

    private int age;
    //class-level JsonIgnore kullanimina ornektir. @JsonIgnoreProperties("age") deyimi ile "age" fieldi da password gibi kullanici tarafinda gorunmeyecektir.

    /**
     * Response' ta kullanicidan saklamak istedigimiz fieldlari direkt fieldin uzerine @JsonIgnore yazarak veya
     * classin ustune @JsonIgnoreProperties({"age","first_name"}) yazarak saklayabiliriz.
     * Boylece response' ta bu fieldlara ait bilgiler donmeyecektir.
     * Tavsiye edilen kullanim field uzerindeki @JsonIgnore' u kullanmaktir zira fieldin adi degisirse classin basindaki notasyonun icinde de degistirmek gerekecektir.
     * Bu iki notasyonun kullanimi STATIC FILTERING' tir.
     * */
}
