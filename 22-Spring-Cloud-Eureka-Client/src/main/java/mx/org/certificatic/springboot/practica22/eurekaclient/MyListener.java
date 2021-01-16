package mx.org.certificatic.springboot.practica22.eurekaclient;

import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener implements ApplicationListener<ServletWebServerInitializedEvent> {

	public static int APPLICATION_PORT;

	@Override
	public void onApplicationEvent(final ServletWebServerInitializedEvent event) {
		APPLICATION_PORT = event.getWebServer().getPort();
	}
}