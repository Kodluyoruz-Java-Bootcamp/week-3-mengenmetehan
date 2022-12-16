package com.emlakcepte.repository;

import com.emlakcepte.model.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {

    private static List<Message> messageList = new ArrayList<>();

    public void saveMessage(Message message) {
        messageList.add(message);
    }

    public List<Message> findAll() {
        return messageList;
    }

    public boolean deleteMessage(Message message)
    {
        return messageList.remove(message);
    }

    public void updateMessage (Message message, Message updated)
    {
        if (messageList.contains(message)) {
            messageList.remove(message);
            messageList.add(updated);
        }
    }

}
