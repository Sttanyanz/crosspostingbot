package io.github.sttanyanz.crosspostingbot.telegram;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import io.github.sttanyanz.crosspostingbot.vkontakte.VkontakteService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {

    private final VkontakteService vkontakteService;

    public Bot(@Value("${bot.token}") String token, VkontakteService vkontakteService) {
        super(token);
        this.vkontakteService = vkontakteService;
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            vkontakteService.postToGroup(update.getMessage().getText());
        } catch (ClientException | ApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return "oxpostbot";
    }
}
