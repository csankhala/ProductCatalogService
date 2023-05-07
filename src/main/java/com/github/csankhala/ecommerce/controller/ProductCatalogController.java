package com.github.csankhala.ecommerce.controller;

import com.github.csankhala.ecommerce.dto.ProductDto;
import com.github.csankhala.ecommerce.entity.Product;
import com.github.csankhala.ecommerce.mapper.ProductCatalogMapper;
import com.github.csankhala.ecommerce.service.ProductService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/v1/product")
public class ProductCatalogController {

    private final ProductService productService;
    private final ProductCatalogMapper productMapper;

    @Inject
    public ProductCatalogController(ProductService productService, ProductCatalogMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @Post(uri = "/", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ProductDto create(@Body ProductDto productDto) {
        return this.productMapper.map(this.productService.add(this.productMapper.map(productDto)));
    }

    @Get(uri = "/{id}", produces = MediaType.APPLICATION_JSON)
    public ProductDto get(@PathVariable long id) {
        return this.productMapper.map(this.productService.get(id));
    }

    @Get(uri = "/", produces = MediaType.APPLICATION_JSON)
    public List<ProductDto> get() {
        return this.productMapper.map(this.productService.getAll());
    }

    @Delete(uri = "/{id}")
    public void delete(@PathVariable long id) {
        this.productService.delete(id);
    }

    @Put(uri = "/{id}", consumes = MediaType.APPLICATION_JSON)
    public ProductDto delete(@PathVariable long id, @Body Product productDto) {
        return null;
    }

}