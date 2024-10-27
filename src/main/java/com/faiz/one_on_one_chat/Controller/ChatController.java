package com.faiz.one_on_one_chat.Controller;

import com.faiz.one_on_one_chat.Model.Chat;
import com.faiz.one_on_one_chat.Model.ChatNotification;
import com.faiz.one_on_one_chat.Services.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class ChatController {
    private final SimpMessagingTemplate template;
    private final ChatService chatService;

    @MessageMapping("/chat")
    public void processMessage(
            @Payload Chat chat) {
        Chat saved = chatService.save(chat);
        template.convertAndSendToUser(
                chat.getReceiverId(), "/queue/messages",
                ChatNotification.builder()
                        .id(saved.getId())
                        .senderId(saved.getSenderId())
                        .receiverId(saved.getReceiverId())
                        .message(saved.getContent())
                        .build()
                );
    }

    @GetMapping("/messages/{senderID}/{receiverID}")
    public ResponseEntity<List<Chat>> getChat(@PathVariable String senderID,
                                              @PathVariable String receiverID) {
        return ResponseEntity
                .ok(chatService.findChatMessages(senderID, receiverID));
    }
}
