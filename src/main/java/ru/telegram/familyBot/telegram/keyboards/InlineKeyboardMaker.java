package ru.telegram.familyBot.telegram.keyboards;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.telegram.familyBot.constants.bot.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Клавиатуры, формируемые в сообщении
 */
@Component
public class InlineKeyboardMaker {

    public InlineKeyboardMarkup getInlineMessageButtons(ButtonNameEnum buttonNameEnum) {
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        if (buttonNameEnum.equals(ButtonNameEnum.WORK_WITH_DATE)) {
            for (InlineButtonNameEnum ibn : InlineButtonList.WORK_WITH_DATE.getInlineButtonList()) {
                rowList.add(getButton(ibn));
            }
        }

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }

    private List<InlineKeyboardButton> getButton(InlineButtonNameEnum ibn) {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(ibn.getInlineButtonName());
        button.setCallbackData(ibn.name());

        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(button);
        return keyboardButtonsRow;
    }
}
