package mx.org.certificatic.springboot.practica14.throttling.throttler;

import java.util.Timer;
import java.util.TimerTask;

public class ThrottleTimerImpl implements Throttler {

	// Define propiedad correspondiente el delay en el cual el throttler (regulador)
	// va a regular la cantidad de llamadas por segundo.
	private final int throttlePeriod;
	
	// Define la propiedad de bean CallsCount
	private final CallsCount callsCount;

	// Inyecta propiedades por constructor
	public ThrottleTimerImpl(int throttlePeriod, CallsCount callsCount) {
		this.throttlePeriod = throttlePeriod;
		this.callsCount = callsCount;
	}

	@Override
	public void start() {

		// Implementa
		new Timer(true).schedule(new TimerTask() {
			
			@Override
			public void run() {
				callsCount.resetAll();
			}
			
		}, 0, throttlePeriod);
	}
}
