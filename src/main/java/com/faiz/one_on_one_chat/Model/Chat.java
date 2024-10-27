package com.faiz.one_on_one_chat.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Chat {
    @Id
    private String id;
    private String chatId;
    private String senderId;
    private String receiverId;
    private String content;
    private Date timestamp;
}
