package mx.org.certificatic.springboot.practica15.eventsourcing.processor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import mx.org.certificatic.springboot.practica15.eventsourcing.events.DomainEvent;
import mx.org.certificatic.springboot.practica15.eventsourcing.events.domainevents.AccountCreateEvent;
import mx.org.certificatic.springboot.practica15.eventsourcing.events.domainevents.MoneyDepositEvent;
import mx.org.certificatic.springboot.practica15.eventsourcing.events.domainevents.MoneyTransferEvent;
import mx.org.certificatic.springboot.practica15.eventsourcing.events.domainevents.MoneyWithdrawalEvent;
import mx.org.certificatic.springboot.practica15.eventsourcing.events.exception.JournalException;

@Component
public class JsonFileJournal {

	@Autowired
	private Gson gson;

	private File aFile;
	private List<String> listOfEventsAsString;
	private int index;

	@PostConstruct
	public void readJournal() {
		listOfEventsAsString = new ArrayList<>();
		index = 0;

		aFile = new File("Journal.json");

		if (aFile.exists()) {
			try (BufferedReader input = new BufferedReader(
					new InputStreamReader(new FileInputStream(aFile), "UTF-8"))) {

				String line;

				while ((line = input.readLine()) != null) {
					listOfEventsAsString.add(line);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		} else {
			this.reset();
		}
	}

	public void write(DomainEvent domainEvent) {

		JsonElement jsonElement;

		if (domainEvent instanceof AccountCreateEvent) {

			jsonElement = gson.toJsonTree(domainEvent, AccountCreateEvent.class);

		} else if (domainEvent instanceof MoneyDepositEvent) {

			jsonElement = gson.toJsonTree(domainEvent, MoneyDepositEvent.class);

		} else if (domainEvent instanceof MoneyWithdrawalEvent) {

			jsonElement = gson.toJsonTree(domainEvent, MoneyWithdrawalEvent.class);

		} else if (domainEvent instanceof MoneyTransferEvent) {

			jsonElement = gson.toJsonTree(domainEvent, MoneyTransferEvent.class);

		} else {

			throw new JournalException("Journal Event not recegnized");
		}

		try (Writer output = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(aFile, true), "UTF-8"))) {

			String eventString = jsonElement.toString();

			output.write(eventString + "\r\n");

		} catch (IOException e) {

			throw new RuntimeException(e);
		}
	}

	public void reset() {
		aFile.delete();
	}

	public DomainEvent readNext() {

		if (index >= listOfEventsAsString.size()) {
			return null;
		}

		String event = listOfEventsAsString.get(index);

		index++;

		JsonParser parser = new JsonParser();
		JsonElement jsonElement = parser.parse(event);

		String eventClassName = jsonElement.getAsJsonObject().get("eventClassName").getAsString();
		DomainEvent domainEvent;

		if (eventClassName.equals(AccountCreateEvent.class.getSimpleName())) {

			domainEvent = gson.fromJson(jsonElement, AccountCreateEvent.class);

		} else if (eventClassName.equals(MoneyDepositEvent.class.getSimpleName())) {

			domainEvent = gson.fromJson(jsonElement, MoneyDepositEvent.class);

		} else if (eventClassName.equals(MoneyWithdrawalEvent.class.getSimpleName())) {

			domainEvent = gson.fromJson(jsonElement, MoneyWithdrawalEvent.class);

		} else if (eventClassName.equals(MoneyTransferEvent.class.getSimpleName())) {

			domainEvent = gson.fromJson(jsonElement, MoneyTransferEvent.class);

		} else {
			throw new JournalException("Journal Event not recegnized");
		}

		domainEvent.setRealTime(false);

		return domainEvent;
	}
}
