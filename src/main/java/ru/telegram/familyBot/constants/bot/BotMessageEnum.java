package ru.telegram.familyBot.constants.bot;

/**
 * Текстовые сообщения, посылаемые ботом
 */
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

    // прочие ошибки
    EXCEPTION_BASE("Что-то пошло не так, и я запутался. Позовите отца");

    private final String message;


    BotMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
