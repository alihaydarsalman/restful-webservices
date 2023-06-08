package com.hzyazilimci.webservices.restfulwebservices.filtering.staticFiltering;

import com.hzyazilimci.webservices.restfulwebservices.filtering.staticFiltering.MyBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author hzyazilimci
 */

@RestController
@RequestMapping("/staticFiltering")
public class FilteringController {

    MyBean myBean = new MyBean("Alihaydar","Salman","Test1234",24);

    MyBean[] myBeans = new MyBean[]{myBean,
            new MyBean("Kemal","Bardakci","Deneme123",36),
            new MyBean("Jason","Statham","123123",45)};

    @GetMapping
    public MyBean filtering(){
        return myBean;
    }

    @GetMapping("/getAll")
    public List<MyBean> getAllFiltering(){
        return Arrays.asList(myBeans);
    }
}
