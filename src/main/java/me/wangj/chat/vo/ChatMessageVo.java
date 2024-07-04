package me.wangj.chat.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author wj
 */
@Schema(name = "chat message object")
@Data
public class ChatMessageVo {

    @Schema(name = "答案内容，可以是卡片答案")
    private String answer;

    @Schema(name = "windowId")
    private String windowId;

    @Schema(name = "端标识")
    private String instanceId;

}
