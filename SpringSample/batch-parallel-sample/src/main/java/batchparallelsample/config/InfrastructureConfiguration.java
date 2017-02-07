package batchparallelsample.config;

import javax.sql.DataSource;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jms.core.JmsTemplate;

public interface InfrastructureConfiguration {
	@Bean
	public abstract DataSource dataSource();
 
	@Bean
	public abstract TaskExecutor taskExecutor();
 
	@Bean
	public abstract ConnectionFactory connectionFactory();
 
	@Bean
	public abstract Queue queue();
 
	@Bean
	public abstract JmsTemplate jmsTemplate();
}
