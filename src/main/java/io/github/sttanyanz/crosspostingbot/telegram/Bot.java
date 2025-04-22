package io.github.sttanyanz.crosspostingbot.telegram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {

    public Bot(@Value("${bot.token}") String token) {
        super(token);
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId());
        message.setText("Привет, " + update.getMessage().getFrom().getFirstName() +
                ".\nКакая у вас погода на улице?");
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return "oxpostbot";
    }
}
