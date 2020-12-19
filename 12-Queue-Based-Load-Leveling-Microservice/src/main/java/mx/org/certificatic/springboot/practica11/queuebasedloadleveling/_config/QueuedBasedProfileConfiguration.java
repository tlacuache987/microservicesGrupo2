package mx.org.certificatic.springboot.practica11.queuebasedloadleveling._config;

import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import mx.org.certificatic.springboot.practica11.queuebasedloadleveling._config.profile.QueuedBasedProfile;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.queue.MessageQueue;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.service.ITaskService;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.service.impl.TaskService;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.ITaskConsumer;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.ITaskProducer;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.consumer.impl.MessageQueueBasedTaskConsumer;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.producer.impl.MessageQueueBasedTaskProducer;

@Configuration
@QueuedBasedProfile
public class QueuedBasedProfileConfiguration {

	private static final int NUM_CONSUMERS = 6;

	// Implementa
	@Autowired
	@Qualifier("myExecutorService")
	private ExecutorService myExecutorService;

	@Autowired
	private ObjectFactory<ITaskProducer> taskProducerFactory;

	@Autowired
	private ObjectFactory<ITaskConsumer> taskConsumerFactory;

	@Bean
	public MessageQueue messageQueue() {
		return new MessageQueue();
	}

	@Bean
	@Scope("prototype")
	public ITaskConsumer messageQueueTaskConsumer() {
		return new MessageQueueBasedTaskConsumer(ApplicationConfig.CONSUMER_TASK_DELAY, messageQueue());
	}

	@Bean
	@Scope("prototype")
	public ITaskProducer messageQueueTaskProducer() {
		return new MessageQueueBasedTaskProducer(1, ApplicationConfig.PRODUCER_TASK_DELAY, messageQueue());
	}

	@Bean
	public ITaskService taskService() {
		return new TaskService(myExecutorService, taskProducerFactory);
	}

	@Bean
	public CommandLineRunner startConsumer() {
		return (args) -> {
			for (int i = 0; i < NUM_CONSUMERS; i++)
				myExecutorService.submit((Runnable) taskConsumerFactory.getObject());
		};
	}

}
