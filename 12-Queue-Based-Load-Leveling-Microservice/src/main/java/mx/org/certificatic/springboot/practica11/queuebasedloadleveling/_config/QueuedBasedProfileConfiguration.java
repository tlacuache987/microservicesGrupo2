package mx.org.certificatic.springboot.practica11.queuebasedloadleveling._config;

import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import mx.org.certificatic.springboot.practica11.queuebasedloadleveling._config.profile.QueuedBasedProfile;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.queue.MessageQueue;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.service.ITaskService;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.service.impl.TaskService;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.consumer.impl.MessageQueueBasedTaskConsumer;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.producer.impl.MessageQueueBasedTaskProducer;

@Configuration
@QueuedBasedProfile
public class QueuedBasedProfileConfiguration {

	// Implementa

}
