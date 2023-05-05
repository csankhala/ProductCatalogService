package com.github.csankhala;

import io.micronaut.http.annotation.*;

@Controller("/productCatalogService")
public class ProductCatalogServiceController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}