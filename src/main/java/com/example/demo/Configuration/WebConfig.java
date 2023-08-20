package com.example.demo.Configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

	public WebConfig() {
		super();
	}
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
		 registry.addViewController("/Admin.html");
	      
    	
	}
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/**",
        		"/css/**",
                "/resources/**",
                "/js/**",
                "/image/**",
                "/api/**",
                "/font-awesome/**"
               
               )
		        .addResourceLocations(
        		   "classpath:/static/css/",
        		   "classpath:/static/js/",
        		   "classpath:/static/image/",
        		   "classpath:/static/api/",
                   "classpath:/resources/",
                   "classpath:/static/font-awesome/");
	}
	
	@Bean
    @ConditionalOnMissingBean(RequestContextListener.class)
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
	
}
