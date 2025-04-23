package io.github.sttanyanz.crosspostingbot.config;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VkontakteConfig {

    @Value("${vk.access-token}")
    private String accessToken;

    @Value("${vk.group-id}")
    private long groupId;

    @Bean
    public VkApiClient vkApiClient() {
        TransportClient transportClient = new HttpTransportClient();
        return new VkApiClient(transportClient);
    }

    @Bean
    public String vkAccessToken() {
        return accessToken;
    }

    @Bean
    public long vkGroupId() {
        return -groupId;
    }
}