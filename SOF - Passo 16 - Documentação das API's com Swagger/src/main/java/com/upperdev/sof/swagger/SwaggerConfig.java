package com.upperdev.sof.swagger;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	
	@Bean
	public Docket api() {

		
		//Criando um objeto "Docket", que é um objeto que o Spring, internamente vai usar para gerar a pagina html Swagger de documentacao.
		Docket docketASerRetornado = new Docket( DocumentationType.SWAGGER_2 );
		

		return docketASerRetornado.select()
			 	                  .apis(RequestHandlerSelectors.basePackage("com.upperdev.sof.controller.api")) //Obs: Aqui é preciso digitar o nome base do pacote onde estão as classes com os códigos das nossas api's.
				                  .paths( PathSelectors.any() )
				                  .build()
				                  .apiInfo( apiInfo() )
				                  .useDefaultResponseMessages(true);
	}

	
	
	
	//Metodo que que retorna um objeto "ApiInfo". Esse objeto vai conter informacoes que vao aparecer na interface visual do Swagger com o detalhamento dos endpoints.
	private ApiInfo apiInfo() {
		
		
		//Definição de texto da pagina da documentação visual.
	    String  title             = "Documentação das API's do projeto'";
	    String  description       = "Lista de endpoints da aplicação com detalhamento";
        String  version           = "1.0";
        String  termsOfServiceUrl = "https://www.upperdev.com";
        String  license           = "Licensa - Todos os direitos reservados.";
        String  licenseUrl        = "https://www.upperdev.com";
        Contact contact           = new Contact("Erik Lima", "https://www.upperdev.com", "erik@upperdev.com");

	
        ApiInfo apiInfo = new ApiInfo( 
        		                       title, 
        		                       description, 
        		                       version, 
        		                       termsOfServiceUrl, 
        		                       contact, 
        		                       license, 
        		                       licenseUrl, 
	                                   Collections.emptyList()
	                                  );
	    return apiInfo;	
	}

}