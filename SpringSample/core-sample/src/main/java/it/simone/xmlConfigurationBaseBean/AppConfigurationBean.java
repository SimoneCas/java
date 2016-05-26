package it.simone.xmlConfigurationBaseBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfigurationBean {

	@Bean
	public SpringFather father(){
		return new SpringFather(child());
	}
	
	@Bean
	public Child child(){
		return new OtherChild();
	}
}
