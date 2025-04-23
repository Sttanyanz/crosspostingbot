package io.github.sttanyanz.crosspostingbot.vkontakte;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.wall.responses.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VkontakteService {

    private final VkApiClient vkApiClient;
    private final String vkAccessToken;
    private final long vkGroupId;

    public PostResponse postToGroup(String message) throws ClientException, ApiException {
            UserActor actor = new UserActor(vkGroupId, vkAccessToken);

        return vkApiClient.wall()
                .post(actor)
                .ownerId(vkGroupId)
                .message(message)
                .execute();
    }
}
