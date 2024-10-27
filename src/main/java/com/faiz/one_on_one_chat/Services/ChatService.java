package com.faiz.one_on_one_chat.Services;

import com.faiz.one_on_one_chat.Model.Chat;
import com.faiz.one_on_one_chat.Repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final ChatRoomService chatRoomService;

    public Chat save(Chat chat) {
       var chatId = chatRoomService.getChatId(
               chat.getSenderId(),
               chat.getReceiverId(),
               false)
               .orElseThrow();
       chat.setChatId(chatId);
       chatRepository.save(chat);
       return chat;
    }

    public List<Chat> findChatMessages(String senderId, String receiverId) {
        var chatId = chatRoomService.
                getChatId(senderId,
                        receiverId,
                        false);
        return chatId.map(chatRepository :: findByChatId).orElse(new ArrayList<>());
    }
}
