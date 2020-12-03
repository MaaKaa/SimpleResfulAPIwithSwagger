package pl.maakaa.app.swagger;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Class defining the details of the API-Rest controllers through Swagger.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket produceApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("pl.maakaa.app"))
                .paths(paths())
                .build();
    }

    //APIs' description
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Exemplary Rest API")
                .description("This is a simple description")
                .version("1-0-SNAPSHOT")
                .build();
    }

    //Method provides API's mapping endpoints.
    //Allow paths that matches the given Predicate
    private Predicate<String> paths() {
        return Predicates.and(
                PathSelectors.regex("/books.*"),
                Predicates.not(PathSelectors.regex("/error.*")));
    }
}
