package com.custom.ecommerceapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.custom.ecommerceapp.entity.Product;
import com.custom.ecommerceapp.entity.ProductCategory;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
		
		HttpMethod[] theUnsupportedActionsHttpMethods = {HttpMethod.PUT,HttpMethod.POST, HttpMethod.DELETE};
		
		config.getExposureConfiguration()
			.forDomainType(Product.class)
			.withItemExposure((metdata,httpMethods) -> httpMethods.disable(theUnsupportedActionsHttpMethods))
			.withCollectionExposure((metdata,httpMethods) -> httpMethods.disable(theUnsupportedActionsHttpMethods));
		
		config.getExposureConfiguration()
			.forDomainType(ProductCategory.class)
			.withItemExposure((metdata,httpMethods) -> httpMethods.disable(theUnsupportedActionsHttpMethods))
			.withCollectionExposure((metdata,httpMethods) -> httpMethods.disable(theUnsupportedActionsHttpMethods));
	}
	
	

}
