package batchparallelsample.processor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemProcessor;


public class LogItemProcessor<T> implements ItemProcessor<T,T> {

	private static final Log log = LogFactory.getLog(LogItemProcessor.class);
	
	public T process(T item) throws Exception {
		log.info(item);
		//log.info(Thread.currentThread().getName());
		return item;
	}

}