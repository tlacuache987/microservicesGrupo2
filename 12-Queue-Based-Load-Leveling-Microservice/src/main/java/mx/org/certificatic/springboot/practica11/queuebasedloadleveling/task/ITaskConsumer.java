package mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task;

import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.model.Message;

public interface ITaskConsumer {

	void consume(Message message);
}
