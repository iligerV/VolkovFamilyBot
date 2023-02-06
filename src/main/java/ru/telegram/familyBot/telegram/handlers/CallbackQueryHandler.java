package ru.telegram.familyBot.telegram.handlers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import ru.telegram.familyBot.constants.bot.BotMessageEnum;
import ru.telegram.familyBot.constants.bot.InlineButtonNameEnum;
import ru.telegram.familyBot.exceptions.EventNotFoundException;
import ru.telegram.familyBot.exceptions.PersonNotFoundException;
import ru.telegram.familyBot.telegram.TelegramApiClient;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class CallbackQueryHandler {
    TelegramApiClient telegramApiClient;

    public BotApiMethod<?> processCallbackQuery(CallbackQuery buttonQuery) {
        final String chatId = buttonQuery.getMessage().getChatId().toString();

        InlineButtonNameEnum ibne = InlineButtonNameEnum.valueOf(buttonQuery.getData());

        switch (ibne) {
            case GET_ALL_BIRTH_DATES:
                return getBirthDatesMessage(chatId);
            case GET_ALL_EVENTS_DATES:
                return getEventsDatesMessage(chatId);
            default:
                return new SendMessage(chatId, BotMessageEnum.EXCEPTION_BAD_BUTTON_NAME_MESSAGE.getMessage());
        }
    }

    private SendMessage getBirthDatesMessage(String chatId) {
        try {
            return new SendMessage(chatId, telegramApiClient.getPersonDate());
        } catch (PersonNotFoundException e) {
            return new SendMessage(chatId, BotMessageEnum.PERSON_NOT_FOUND.getMessage());
        } catch (Exception e) {
            return new SendMessage(chatId, BotMessageEnum.EXCEPTION_BASE.getMessage());
        }
    }

    private SendMessage getEventsDatesMessage(String chatId) {
        try {
            return new SendMessage(chatId, telegramApiClient.getEventDate());
        } catch (EventNotFoundException e) {
            return new SendMessage(chatId, BotMessageEnum.EVENT_NOT_FOUND.getMessage());
        } catch (Exception e) {
            return new SendMessage(chatId, BotMessageEnum.EXCEPTION_BASE.getMessage());
        }
    }
}
