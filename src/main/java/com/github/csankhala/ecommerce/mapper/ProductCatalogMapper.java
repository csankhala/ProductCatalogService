package com.github.csankhala.ecommerce.mapper;

import com.github.csankhala.ecommerce.dto.ProductDto;
import com.github.csankhala.ecommerce.entity.Product;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "jsr330")
public interface ProductCatalogMapper {
    ProductDto map(Product product);
    Product map(ProductDto product);
    List<ProductDto> map(Collection<Product> product);
}
