package ru.telegram.familyBot.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import ru.telegram.familyBot.telegram.FamilyBot;
import ru.telegram.familyBot.telegram.handlers.CallbackQueryHandler;
import ru.telegram.familyBot.telegram.handlers.MessageHandler;

@Configuration
@AllArgsConstructor
public class SpringConfig {
    private final TelegramConfig telegramConfig;

    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder().url(telegramConfig.getWebhookPath()).build();
    }

    @Bean
    public FamilyBot springWebhookBot(
            SetWebhook setWebhook,
            MessageHandler messageHandler,
            CallbackQueryHandler callbackQueryHandler
    ) {
        FamilyBot bot = new FamilyBot(setWebhook, messageHandler, callbackQueryHandler);

        bot.setBotPath(telegramConfig.getWebhookPath());
        bot.setBotUsername(telegramConfig.getBotName());
        bot.setBotToken(telegramConfig.getBotToken());

        return bot;
    }
}