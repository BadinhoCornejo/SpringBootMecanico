package com.badinho.SowadMecanico.configurations;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer{


	/*
	public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/notFound").setViewName("404");
    }
     */

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(
				"/webjars/**",
				"/img/**",
				"/css/**",
				"/js/**")
				.addResourceLocations(
						"classpath:/META-INF/resources/webjars/",
						"classpath:/static/img/",
						"classpath:/static/css/",
						"classpath:/static/js/");
	}

    @Override
    public void	addCorsMappings(CorsRegistry registry){
		registry.
				addMapping("/**")
				.allowedOrigins("http://localhost:4200")
				.allowedHeaders("*")
				.allowedMethods("GET", "POST","PUT", "DELETE")
				.allowCredentials(true);
	}

	/*
	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> containerCustomizer() {
	    return container -> {
	        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,
	                "/notFound"));
	    };
	  }
	*/
}
