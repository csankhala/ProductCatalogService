package com.github.csankhala.ecommerce;

import com.github.csankhala.ecommerce.dto.ProductDto;
import com.github.csankhala.ecommerce.entity.Product;
import com.github.csankhala.ecommerce.service.ProductService;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class ProductCatalogApplicationTest {

    @Inject
    EmbeddedApplication<?> application;

    @Inject
    ProductService productService;

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void testCreateAndGetProduct() {
        ProductDto productDto = new ProductDto();
        productDto.setId(3);
        productDto.setName("Test Product 3");
        productDto.setPrice(10.0);

        HttpRequest<ProductDto> request = HttpRequest.POST("/v1/product", productDto).contentType("application/json");

        ProductDto responseDto = client.toBlocking().retrieve(request, ProductDto.class);

        assertEquals(productDto.getName(), responseDto.getName());
        assertEquals(productDto.getPrice(), responseDto.getPrice());

        long productId = responseDto.getId();

        request = HttpRequest.GET("/v1/product/" + productId);

        responseDto = client.toBlocking().retrieve(request, ProductDto.class);

        assertNotNull(responseDto);
        assertEquals(productId, responseDto.getId());
        assertEquals(productDto.getName(), responseDto.getName());
        assertEquals(productDto.getPrice(), responseDto.getPrice());
    }

    @Test
    void testGetAllProducts() {
        productService.clear();
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Test Product 1");
        product1.setPrice(10.0);
        productService.add(product1);

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Test Product 2");
        product2.setPrice(20.0);
        productService.add(product2);

        HttpRequest<Object> request = HttpRequest.GET("/v1/product");

        List<ProductDto> responseDtoList = client.toBlocking().retrieve(request, Argument.listOf(ProductDto.class));

        assertNotNull(responseDtoList);
        assertEquals(2, responseDtoList.size());
    }

    @Test
    void testDeleteProduct() {
        // Create a product to be deleted
        Product product = new Product();
        product.setId(4L);
        product.setName("Test Product 4");
        product.setPrice(10);
        productService.add(product);

        // Send a DELETE request to delete the product
        HttpRequest<Object> request = HttpRequest.DELETE("/v1/product/" + product.getId());
        HttpResponse<String> response = client.toBlocking().exchange(request, String.class);

        // Verify that the response status code is 204 No Content
        assertEquals(HttpStatus.OK, response.getStatus());

        // Verify that the product has been deleted from the service
        assertNull(productService.get(4L));
    }
}
