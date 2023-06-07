package com.hzyazilimci.webservices.restfulwebservices.utils.hateoas;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

import java.util.List;

/**
 * @author hzyazilimci
 */
public class CustomEntityModel<T> extends EntityModel<T> {
    public CustomEntityModel(T content, Link... links) {
        super(content, List.of(links));
    }
}
