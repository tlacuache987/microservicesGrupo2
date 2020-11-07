package mx.org.certificatic.springboot.practica11.queuebasedloadleveling.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.model.Message;

@Slf4j
public class MessageQueue {

	private BlockingQueue<Message> blockingQueue = new ArrayBlockingQueue<Message>(1024);

	public void submitMessage(Message message) {

		// implementa
	}

	public Message retrieveMessage() {
		
		// Implementa
		return null;
	}
}