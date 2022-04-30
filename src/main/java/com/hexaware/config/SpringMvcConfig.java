package com.hexaware.config;
import javax.sql.DataSource;

import com.hexaware.dao.*;
import com.hexaware.sql.CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.hexaware")
public class SpringMvcConfig extends WebMvcConfigurerAdapter{


	  @Bean
	  public ViewResolver jstlViewResolver() {
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver(); // NOTE: this time I'm using InternalResourceViewResolver and again it does not matter :)
	    resolver.setPrefix("");
	    resolver.setSuffix(".html");
	    return resolver;
	  }
	  

	  @Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**").
	    addResourceLocations("/resources/");

	  }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
    }
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/jdbcdemo?allowPublicKeyRetrieval=true&useSSL=false\r\n");
        dataSource.setUsername("root");
        dataSource.setPassword("SGANESHRAM7s");
         
        return dataSource;
    }
    @Bean
    public EmployeeDAO getEmployeeDAO() {
        return new EmployeeDAOImpl(getDataSource());
    }
    @Bean
    public AddressDAO getAddressDAO() {
        return new AddressDAOImpl(getDataSource());
    }
    @Bean
    public LoginDAO getLoginDAO() {
        return new LoginDAOImpl(getDataSource());
    }
    
    @Bean
    public CRUD getCRUDDao() {
    	return new CRUD(getDataSource());
    }
    
    @Bean
    public ReportDAO getReportDAO() {
    	return new ReportDaoImpl(getDataSource());
    }
}
