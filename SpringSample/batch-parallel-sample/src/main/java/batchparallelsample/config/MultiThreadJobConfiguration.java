package batchparallelsample.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.partition.support.MultiResourcePartitioner;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.jms.JmsItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

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
