package mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.producer.impl;

import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.model.Message;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.ITaskProducer;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.consumer.impl.SimpleTaskConsumer;

@Slf4j
// Elimina abstract
public abstract class SimpleTaskProducer implements ITaskProducer, Runnable {

	// Implementa
}