package com.packt.webstore.util;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kamil on 2017-12-14.
 */
public class WebDataBinderFields { //todo: get this woring with ProductController.initialiseBinder

    public static final List<String> productAllowedFields = Arrays.asList(
            "productId",
            "name",
            "unitPrice",
            "description",
            "manufacturer",
            "category",
            "unitsInStock",
            "productImage",
            "productInstruction");

    public static final List<String> productDisallowedFields = Arrays.asList(
            "unitsInOrder",
            "discounted");
}
