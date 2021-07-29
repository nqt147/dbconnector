package com.vn.paysmart.dbconnector.common;

import com.vn.paysmart.dbconnector.entity.SlackMessage;
import com.vn.paysmart.dbconnector.slack.SlackConnector;
import org.springframework.stereotype.Component;

@Component
public class SlackUtils {

    public void sendMessage(String messages){
        SlackMessage slackMessage = SlackMessage.builder()
                .username("thinh.nguyen.1")
                .text(messages)
                .icon_emoji(":twice:")
                .build();
        SlackConnector.sendMessage(slackMessage);
    }
}
