package mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.consumer.impl;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.model.Message;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.queue.MessageQueue;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.ITaskConsumer;

@Slf4j
// elimina abstract
public class MessageQueueBasedTaskConsumer implements ITaskConsumer, Runnable {

	// Implementa
	private int delay;
	private MessageQueue messageQueue;

	public MessageQueueBasedTaskConsumer(int delay, MessageQueue messageQueue) {
			this.delay = delay;
			this.messageQueue = messageQueue;
		}

	@Override
	@SneakyThrows
	public void consume(Message message) {

		Thread.sleep(delay);

		log.info(message.getMessage() + " is consumed.");
	}

	@Override
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {

				Message message = messageQueue.retrieveMessage();

				if (null != message) {
					this.consume(message);
				} else {
					log.info("Service Executor: Waiting for Messages to serve .. ");
				}

				Thread.sleep(3000);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

}
