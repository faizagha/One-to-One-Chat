package com.faiz.one_on_one_chat.Repository;

import com.faiz.one_on_one_chat.Model.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {

    Optional<ChatRoom> findBySenderIdAndReceiverId(String senderId, String receiverId);
}
