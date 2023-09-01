//package com.dnapass.training;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import static springfox.documentation.builders.PathSelectors.regex;
//@Configuration
//@EnableSwagger2
//public class SwaggerFarmToMarkte {
//
//	@Bean
//	public Docket FarmToMarket() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.dnapass"))
//				.paths(regex("/farmmarket.*"))
//				.build();
//	}
//}
