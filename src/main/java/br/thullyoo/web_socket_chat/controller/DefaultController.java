package br.thullyoo.web_socket_chat.controller;

import br.thullyoo.web_socket_chat.dto.MessageInDTO;
import br.thullyoo.web_socket_chat.dto.MessageOutDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class DefaultController {

    @MessageMapping("/newMessage")
    @SendTo("/channel/livechat")
    public MessageOutDTO publishMessage(MessageInDTO dto){
        return new MessageOutDTO(HtmlUtils.htmlEscape(dto.user() + ": " + dto.message()));
    }

}
