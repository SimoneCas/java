package batchparallelsample.config;



import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.jms.JmsItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.task.TaskExecutor;

import batchparallelsample.processor.LogItemProcessor;
import batchparallelsample.processor.LogItemWriter;
import batchparallelsample.processor.ProtocolListener;

@Configuration
public class MultiThreadJobConfiguration {

		
	@Autowired
	private JobBuilderFactory jobBuilders;
	
	@Autowired
	private StepBuilderFactory stepBuilders;
	
	@Autowired
	private InfrastructureConfiguration infrastructureConfiguration;
	
	@Autowired
	private TaskExecutor taskExecutor;
	
	
	@Bean
	@DependsOn("taskExecutor")
	public Job multiThreadedStepJob(){
		return jobBuilders.get("multiThreadedStepJob")
				.listener(protocolListener())
				.start(step())
				.build();
	}
	
	
	@Bean
	@DependsOn("taskExecutor")
	public Step step(){
		return stepBuilders.get("step")
				.<String,String>chunk(1)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.taskExecutor(taskExecutor)
				.throttleLimit(4)
				.build();
	}
	

	
	@Bean
	@DependsOn("jmsTemplate")
	public JmsItemReader<String> reader(){
		JmsItemReader<String> itemReader = new JmsItemReader<String>();
		itemReader.setJmsTemplate(infrastructureConfiguration.jmsTemplate());
		return itemReader;
	}
	
	@Bean
	@DependsOn("jmsTemplate")
	public ItemProcessor<String,String> processor(){
		return new LogItemProcessor<String>();
	}
	
	@Bean
	@DependsOn("jmsTemplate")
	public ItemWriter<String> writer(){
		return new LogItemWriter<String>();
	}

	@Bean
	public ProtocolListener protocolListener(){
		return new ProtocolListener();
	}
}
