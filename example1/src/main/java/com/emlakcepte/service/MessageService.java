package com.emlakcepte.service;


import com.emlakcepte.model.Message;
import com.emlakcepte.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private MessageRepository m_messageRepository;

    public MessageService(MessageRepository messageRepository)
    {
        m_messageRepository = messageRepository;
    }

    public List<Message> getAll() {
        return m_messageRepository.findAll();
    }

    public void printAll(List<Message> messageList) {
        messageList.forEach(System.out::println);
    }

    public void printAll()
    {
        getAll().forEach(System.out::println);
    }

    public Message saveMessage (Message message)
    {
        m_messageRepository.saveMessage(message);
        return message;
    }

    public void deleteMessage (Message message)
    {
        System.out.println(m_messageRepository.deleteMessage(message) ? "Mesaj silindi" : "Mesaj zaten listede yok");
    }

    public void updateMessage (Message message, Message updated)
    {
        m_messageRepository.updateMessage(message, updated);
    }

}
