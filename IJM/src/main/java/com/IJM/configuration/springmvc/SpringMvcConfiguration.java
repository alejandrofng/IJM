package com.IJM.configuration.springmvc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.IJM")
public class SpringMvcConfiguration extends WebMvcConfigurerAdapter {

	
	@Bean
   	public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
	   
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(converter());
		super.configureMessageConverters(converters);
	}

	@Bean
	MappingJackson2HttpMessageConverter converter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		List<MediaType> mediaTypes = new ArrayList<>();
		mediaTypes.add(MediaType.APPLICATION_JSON);
		converter.setSupportedMediaTypes(mediaTypes);
		converter.setObjectMapper(mapper());
		return converter;
	}

	@Bean
	ObjectMapper mapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Hibernate5Module());
		return mapper;
	}
	
	@PostConstruct//creates directory
	protected void createImagesFolders()
	{
		Boolean success = (new File("C:/IJM")).mkdirs();
		if (!success) {
		    System.out.print("No se pudo crear el directorio");
		}
		(new File("C:/IJM/Images")).mkdirs();
		(new File("C:/IJM/Images/Product")).mkdirs();
	}
}