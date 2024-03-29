package ru.telegram.familyBot.telegram.handlers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.telegram.familyBot.constants.bot.BotMessageEnum;
import ru.telegram.familyBot.constants.bot.ButtonNameEnum;
import ru.telegram.familyBot.telegram.TelegramApiClient;
import ru.telegram.familyBot.telegram.keyboards.InlineKeyboardMaker;
import ru.telegram.familyBot.telegram.keyboards.ReplyKeyboardMaker;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class MessageHandler {
    TelegramApiClient telegramApiClient;
    ReplyKeyboardMaker replyKeyboardMaker;
    InlineKeyboardMaker inlineKeyboardMaker;

    public BotApiMethod<?> answerMessage(Message message) {
        String chatId = message.getChatId().toString();

        String inputText = message.getText();

        if (inputText == null) {
            throw new IllegalArgumentException();
        } else if (inputText.equals("/start")) {
            return getStartMessage(chatId);
        } else if (inputText.equals(ButtonNameEnum.WORK_WITH_DATE.getButtonName())) {
            return getTasksMessage(chatId, inputText);
        } else if (inputText.equals(ButtonNameEnum.HELP_BUTTON.getButtonName())) {
            SendMessage sendMessage = new SendMessage(chatId, BotMessageEnum.HELP_MESSAGE.getMessage());
            sendMessage.enableMarkdown(true);
            return sendMessage;
        } else {
            return new SendMessage(chatId, BotMessageEnum.NON_COMMAND_MESSAGE.getMessage());
        }
    }

    private SendMessage getStartMessage(String chatId) {
        SendMessage sendMessage = new SendMessage(chatId, BotMessageEnum.HELP_MESSAGE.getMessage());
        sendMessage.enableMarkdown(true);
        sendMessage.setReplyMarkup(replyKeyboardMaker.getMainMenuKeyboard());
        return sendMessage;
    }

    private SendMessage getTasksMessage(String chatId, String inputText) {
        SendMessage sendMessage = new SendMessage(chatId, ButtonNameEnum.valueOfButtonName(inputText).getInlineMsg());
        sendMessage.setReplyMarkup(inlineKeyboardMaker.getInlineMessageButtons(ButtonNameEnum.valueOfButtonName(inputText)));
        return sendMessage;
    }
}
