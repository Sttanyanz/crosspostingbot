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

    @Value("${bot.target-channel}")
    private String channelId;
    private final VkontakteService vkontakteService;

    public Bot(@Value("${bot.token}") String token, VkontakteService vkontakteService) {
        super(token);
        this.vkontakteService = vkontakteService;
    }

    @Override
    public void onUpdateReceived(Update update) {
        String text = update.getMessage().getText();
        try {
            vkontakteService.postToGroup(text);
            sendToChannel(channelId, text);
        } catch (ClientException | ApiException | TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "oxpostbot";
    }

    public void sendToChannel(String channelId, String text) throws TelegramApiException {
        SendMessage message = new SendMessage();
        message.setChatId(channelId);
        message.setText(text);

        execute(message);
    }
}
