package com.faiz.one_on_one_chat.Services;

import com.faiz.one_on_one_chat.Model.ChatRoom;
import com.faiz.one_on_one_chat.Repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;
    public Optional<String> getChatId(String senderId,
                                        String receiverId,
                                        boolean createIfNotExist) {
        return chatRoomRepository.findBySenderIdAndReceiverId(senderId, receiverId)
                .map(ChatRoom :: getChatId)
                .or(() -> {
                    if (!createIfNotExist) {
                        var chatId = createChat(senderId, receiverId);
                        return Optional.of(chatId);
                    }
                    return Optional.empty();
                });
    }

    private String createChat(String senderId, String receiverId) {
        var chatId = String.format("%s_%s", senderId, receiverId);
        ChatRoom senderReceiver = ChatRoom.builder()
                .chatId(chatId)
                .senderId(senderId)
                .receiverId(receiverId)
                .build();
        ChatRoom receiverSender = ChatRoom
                .builder()
                .chatId(chatId)
                .senderId(receiverId)
                .receiverId(senderId)
                .build();
        chatRoomRepository.save(senderReceiver);
        chatRoomRepository.save(receiverSender);
        return chatId;
    }


}
