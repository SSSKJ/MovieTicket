package systemanalysis.movieticket.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket buildDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf())
                .select()
                .apis(RequestHandlerSelectors.basePackage("systemanalysis.movieticket.web.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInf(){
    	Contact contact = new Contact();
    	contact.setName("SKJ.Guan");
    	contact.setEmail("438841268@qq.com");
        return new ApiInfoBuilder()
                .title("MovieTicket-API")
                .termsOfServiceUrl("https://github.com/SSSKJ/MovieTicket")
                .description("api for Website BeeBee")
                .build();
    }

}
