package com.adv.empdetailsms.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperConfig {

	  @Bean
	    public ModelMapper modelMapperBean() {
	        return new ModelMapper();
	    }
}
