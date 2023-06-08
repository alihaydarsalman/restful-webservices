package com.hzyazilimci.webservices.restfulwebservices.filtering.dynamicFiltering;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author hzyazilimci
 */

@RestController
@RequestMapping("/dynamicFiltering")
public class DynamicFilteringController {

    DynamicBean dynamicBean = new DynamicBean("Alihaydar","Salman","Test1234",24);

    DynamicBean[] dynamicBeans = new DynamicBean[]{dynamicBean,
            new DynamicBean("Kemal","Bardakci","Deneme123",36),
            new DynamicBean("Jason","Statham","123123",45)};

    @GetMapping
    public MappingJacksonValue filtering(){

        MappingJacksonValue jacksonValue = new MappingJacksonValue(dynamicBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("first_name","last_name","password");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        jacksonValue.setFilters(filters);

        return jacksonValue;
    }

    @GetMapping("/getAll")
    public MappingJacksonValue getAllFiltering(){

        List<DynamicBean> dynamicBeansList = Arrays.asList(dynamicBeans);

        MappingJacksonValue jacksonValue = new MappingJacksonValue(dynamicBeansList);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("first_name","last_name","age");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        jacksonValue.setFilters(filters);

        return jacksonValue;
    }
}
