package ru.telegram.familyBot.telegram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.telegram.familyBot.api.tasks.TaskService;
import ru.telegram.familyBot.constants.bot.BotMessageEnum;
import ru.telegram.familyBot.exceptions.PersonNotFoundException;

import java.io.IOException;
import java.text.MessageFormat;

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

    public String getPersonDate() {
        try {
            return new TaskService().getPerson().toString();
        } catch (IOException e) {
            throw new PersonNotFoundException();
        }
    }
}
