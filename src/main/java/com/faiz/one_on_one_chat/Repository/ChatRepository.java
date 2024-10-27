package com.faiz.one_on_one_chat.Repository;

import com.faiz.one_on_one_chat.Model.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatRepository extends MongoRepository<Chat, String> {
    List<Chat> findByChatId(String chatId);
}
