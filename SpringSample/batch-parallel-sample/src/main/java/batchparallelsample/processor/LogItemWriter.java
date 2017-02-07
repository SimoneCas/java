package batchparallelsample.processor;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;



public class LogItemWriter<T> implements ItemWriter<T> {


	
	private static final Log log = LogFactory.getLog(LogItemWriter.class);
	
	/**
	 * @see ItemWriter#write(java.util.List)
	 */
	public void write(List<? extends T> data) throws Exception {
		log.info(data);
	}

}