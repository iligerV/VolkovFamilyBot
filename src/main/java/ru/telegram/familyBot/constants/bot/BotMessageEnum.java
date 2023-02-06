package ru.telegram.familyBot.constants.bot;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Текстовые сообщения, посылаемые ботом
 */
@Getter
@AllArgsConstructor
public enum BotMessageEnum {
    // ответы на команды с клавиатуры
    HELP_MESSAGE("\uD83D\uDC4B Привет, я часть вашей семьи, и я бот " +
            "давайте дружить ☺ \n\n" +
            "❗ *Что Вы можете сделать:*\n" +
            "✅ завести и напомнтить себе о важных датах\n" +
            "✅ составить лист желаний, которым я поделюсь с вашими близкими\n" +
            "Часть важных для вас дат я уже запомнил. " +
            "Воспользуйтесь клавиатурой, чтобы начать работу\uD83D\uDC47"),
    NON_COMMAND_MESSAGE("Пожалуйста, воспользуйтесь клавиатурой\uD83D\uDC47"),

    // ошибки при обработке callback-ов
    EXCEPTION_BAD_BUTTON_NAME_MESSAGE("Неверное значение кнопки. Крайне странно. Попробуйте позже"),
    PERSON_NOT_FOUND("Пользователь не найден"),
    EVENT_NOT_FOUND("Событие не найдено"),

    // прочие ошибки
    EXCEPTION_BASE("Что-то пошло не так, и я запутался. Позовите отца");

    private final String message;
}
