package me.wangj.chat.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import me.wangj.chat.vo.ChatMessageVo;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import static java.lang.String.format;

/**
 * @author wj
 * @date 2024/7/3
 */
@Tag(name = "chat message controller")
@Controller
@RequiredArgsConstructor
public class MessageController {

    private final SimpMessageSendingOperations messagingTemplate;

    @Operation(summary = "deal with message, accept message and send to the given group")
    @Parameters({
            @Parameter(name = "groupId", description = "group id", required = true, in = ParameterIn.PATH)
    })
    @MessageMapping("/chat/{groupId}/sendMessage")
    public void sendMessage(@DestinationVariable String groupId, @Payload ChatMessageVo message) {
        messagingTemplate.convertAndSend(format("/channel/%s", groupId), message);
    }
}
