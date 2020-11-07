package mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.consumer.impl;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.model.Message;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.queue.MessageQueue;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.ITaskConsumer;

@Slf4j
// elimina abstract
public abstract class MessageQueueBasedTaskConsumer implements ITaskConsumer, Runnable {

	// Implementa

}
