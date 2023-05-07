> This service repo is part of below project:
https://github.com/csankhala/ecommerce-micronaut-kafka

## Requirement
As a product catalog service provider, I want to be able to provide up-to-date information about products to other services in the system, so that customers can make informed purchasing decisions.

Acceptance Criteria:

- The product catalog service should be able to receive requests from other services in the system to retrieve information about a specific product or a list of products.
- The product catalog service should maintain an up-to-date database of product information, including product names, descriptions, prices, and images.
- The product catalog service should be able to handle requests for product information quickly and efficiently, even during high traffic periods.
- If a request is made for a product that is out of stock or no longer available, the product catalog service should return an appropriate error message to the requesting service.
- The product catalog service should provide detailed documentation and a clear API to make it easy for other services to integrate with it.
- The product catalog service should maintain a high level of data accuracy and consistency across all product information.
- The product catalog service should be able to handle updates to product information, such as price changes or new product additions, in a timely manner.
- The product catalog service should provide detailed logs and analytics to help diagnose and troubleshoot any issues that may arise during product information retrieval.

## Setting up the project locally

### IntelliJ setup
The following instructions work for IntelliJ IDEA 2022.1 (Community Edition)

#### Enable annotation processing
- Go to File -> Settings -> Build, Execution, Deployment -> Compiler -> Annotation Processors
- Check 'Enable annotation processing'

#### Setup formatting
* File -> Settings -> Editor -> General -> Ensure line feed at file end on Save
* Install [the 'google-java-format' plugin](https://plugins.jetbrains.com/plugin/8527-google-java-format), and enable it in Settings
* Apply [intellij-java-google-style.xml](https://github.com/google/styleguide/blob/gh-pages/intellij-java-google-style.xml) to [IntelliJ settings](https://www.jetbrains.com/help/idea/configuring-code-style.html#aadfdd2f)

### Run Locally
* Run com.github.csankhala.ecommerce.Application
* Swagger URL: http://localhost:8080/swagger/views/swagger-ui

## Micronaut 3.9.1 Documentation

- [User Guide](https://docs.micronaut.io/3.9.1/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.9.1/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.9.1/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Micronaut Gradle Plugin documentation](https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/)
- [GraalVM Gradle Plugin documentation](https://graalvm.github.io/native-build-tools/latest/gradle-plugin.html)
- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
## Feature swagger-ui documentation

- [Micronaut Swagger UI documentation](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/index.html)

- [https://swagger.io/tools/swagger-ui/](https://swagger.io/tools/swagger-ui/)


## Feature lombok documentation

- [Micronaut Project Lombok documentation](https://docs.micronaut.io/latest/guide/index.html#lombok)

- [https://projectlombok.org/features/all](https://projectlombok.org/features/all)


## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)


## Feature serialization-jackson documentation

- [Micronaut Serialization Jackson Core documentation](https://micronaut-projects.github.io/micronaut-serialization/latest/guide/)


## Feature kafka documentation

- [Micronaut Kafka Messaging documentation](https://micronaut-projects.github.io/micronaut-kafka/latest/guide/index.html)


## Feature test-resources documentation

- [Micronaut Test Resources documentation](https://micronaut-projects.github.io/micronaut-test-resources/latest/guide/)


## Feature openapi documentation

- [Micronaut OpenAPI Support documentation](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/index.html)

- [https://www.openapis.org](https://www.openapis.org)


## Feature micronaut-aop documentation

- [Micronaut Aspect-Oriented Programming (AOP) documentation](https://docs.micronaut.io/latest/guide/index.html#aop)


