package ru.telegram.familyBot.constants.bot;

/**
 * Названия кнопок основной клавиатуры
 */
public enum ButtonNameEnum {
    GET_DATES_BUTTON("Напомнить даты"),
    HELP_BUTTON("Помощь");
    
    private final String buttonName;

    ButtonNameEnum(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getButtonName() {
        return buttonName;
    }
}
