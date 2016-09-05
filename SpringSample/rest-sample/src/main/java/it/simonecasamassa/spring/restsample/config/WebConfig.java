package it.simonecasamassa.spring.restsample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("it")
// ricordarsi che il parametro dell'annotazione è il package da cui ricercare i
// component
public class WebConfig extends WebMvcConfigurerAdapter {

	// Configure a JSP view resolver

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}

	// Definisco View Resolver basato su Content Negotiation
	/*
	 * @Bean public ViewResolver cnViewResolver(ContentNegotiationManager cnm) {
	 * ContentNegotiatingViewResolver cnvr = new
	 * ContentNegotiatingViewResolver(); cnvr.setContentNegotiationManager(cnm);
	 * return cnvr; }
	 */

	// Configure static content handling
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	// configuro contentNegotation per definire di default il tipo di
	// rappresentazione restituita al client
	/*
	 * @Override public void configureContentNegotiation(
	 * ContentNegotiationConfigurer configurer) {
	 * configurer.defaultContentType(MediaType.APPLICATION_JSON); }
	 */
}
