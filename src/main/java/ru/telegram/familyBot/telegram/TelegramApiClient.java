package ru.telegram.familyBot.telegram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.telegram.familyBot.api.tasks.EventService;
import ru.telegram.familyBot.api.tasks.PersonService;
import ru.telegram.familyBot.exceptions.EventNotFoundException;
import ru.telegram.familyBot.exceptions.PersonNotFoundException;
import ru.telegram.familyBot.model.Event;
import ru.telegram.familyBot.model.Person;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class TelegramApiClient {
    private final String URL;
    private final String botToken;

    private final RestTemplate restTemplate;

    public TelegramApiClient(
            @Value("${telegram.api-url}") String URL,
            @Value("${telegram.bot-token}") String botToken
    ) {
        this.URL = URL;
        this.botToken = botToken;
        this.restTemplate = new RestTemplate();
    }

    public String getPersonDate() throws ExecutionException, InterruptedException, PersonNotFoundException {
        List<Person> personList = new PersonService().getPersonDetails();

        StringBuilder personsAsString = new StringBuilder();

        for (Person p : personList) {
            personsAsString
                    .append(p.getName())
                    .append(" -> ")
                    .append(new SimpleDateFormat("dd.MM.yyyy HH:mm").format(p.getDate()))
                    .append(System.getProperty("line.separator"));
        }

        return personsAsString.toString();
    }

    public String getPersonDate(String name) throws ExecutionException, InterruptedException, PersonNotFoundException {
        Person person = new PersonService().getPersonDetails(name);
        return person.getName() + " -> " + new SimpleDateFormat("dd.MM.yyyy HH:mm").format(person.getDate());
    }

    public String getEventDate() throws ExecutionException, InterruptedException, EventNotFoundException {
        List<Event> eventsList = new EventService().getEventsDetails();

        StringBuilder eventsAsString = new StringBuilder();

        for (Event e : eventsList) {
            eventsAsString
                    .append(e.getName())
                    .append(" -> ")
                    .append(new SimpleDateFormat("dd.MM.yyyy HH:mm").format(e.getDate()))
                    .append(System.getProperty("line.separator"));
        }

        return eventsAsString.toString();
    }
}
