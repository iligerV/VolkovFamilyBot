package ru.telegram.familyBot.constants.bot;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Названия кнопок основной клавиатуры
 */

@Getter
@AllArgsConstructor
public enum ButtonNameEnum {
    WORK_WITH_DATE("Работа с датами", "Выберите действие \uD83D\uDC47"),
    HELP_BUTTON("Помощь", "");

    private static final Map<String, ButtonNameEnum> BY_BUTTON_NAME = new HashMap<>();

    static {
        for (ButtonNameEnum e : values()) {
            BY_BUTTON_NAME.put(e.buttonName, e);
        }
    }

    private final String buttonName;
    private final String inlineMsg;

    public static ButtonNameEnum valueOfButtonName(String btnName) {
        return BY_BUTTON_NAME.get(btnName);
    }
}
