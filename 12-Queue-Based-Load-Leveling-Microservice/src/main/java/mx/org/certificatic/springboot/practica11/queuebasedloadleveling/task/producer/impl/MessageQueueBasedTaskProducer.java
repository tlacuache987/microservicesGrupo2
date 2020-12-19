package mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.producer.impl;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.model.Message;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.queue.MessageQueue;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.ITaskProducer;

@Slf4j
// Elimina abstract
public class MessageQueueBasedTaskProducer implements ITaskProducer, Runnable {

	// Implementa
	private MessageQueue messageQueue;
	private int messageCount;
	private int delay;

	public MessageQueueBasedTaskProducer(int messageCount, int delay, MessageQueue messageQueue) {
		this.messageCount = messageCount;
		this.delay = delay;
		this.messageQueue = messageQueue;
	}

	@Override
	public void run() {

		int count = this.messageCount;

		try {
			while (count > 0) {
				String msg = "Message-" + count + " produced by " + Thread.currentThread().getName() + " at "
						+ new Date();

				Thread.sleep(delay);

				log.info(msg);

				this.produce(new Message(msg));

				count--;
			}

		} catch (Exception ex) {
			log.info("error happened: {}", ex.getMessage());
		}

	}

	@Override
	public void produce(Message message) {
		this.messageQueue.submitMessage(message);
	}
}