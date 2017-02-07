package batchparallelsample.config;


import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.sql.DataSource;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableBatchProcessing
public class StandaloneInfrastructureConfiguration implements InfrastructureConfiguration {
	
	@Override
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
		return embeddedDatabaseBuilder.addScript("classpath:org/springframework/batch/core/schema-drop-hsqldb.sql")
				.addScript("classpath:org/springframework/batch/core/schema-hsqldb.sql")
				.addScript("classpath:schema-all.sql")
				.setType(EmbeddedDatabaseType.HSQL)
				.build();
	}

	@Override
	@Bean(name="taskExecutor")
	@ConditionalOnMissingBean(TaskExecutor.class)
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setMaxPoolSize(6);
		taskExecutor.setCorePoolSize(4);
		taskExecutor.afterPropertiesSet();
		return taskExecutor;
	}
	
	@Bean
	public ConnectionFactory connectionFactory() {
		return new ActiveMQConnectionFactory("tcp://localhost:61616");
	}
	
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("queuePerson");
	}
	
	@Bean
	public Queue queue2() {
		return new ActiveMQQueue("queuePerson2");
	}
	
	
	
	@Bean(name="broker")
	public BrokerService broker() throws Exception{
		BrokerService broker = new BrokerService();
		// configure the broker
		broker.addConnector("tcp://localhost:61616");
		broker.start();
		return broker;
	}
	
	@Bean(name="jmsTemplate")
	@DependsOn("broker")
	public JmsTemplate jmsTemplate(){
		JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
		jmsTemplate.setDefaultDestination(queue());
		jmsTemplate.setReceiveTimeout(500);
		for(int i=0; i<100; i++)
			jmsTemplate.convertAndSend("Prova "+i);
		return jmsTemplate;
	}
	
	
	
	
}
