package com.restep.repository.impl;

import com.restep.dataobject.Message;
import com.restep.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author restep
 * @date 2019/9/1
 */
@Service
public class MessageRepositoryImpl implements MessageRepository {
    private static AtomicLong counter = new AtomicLong();
    private final ConcurrentMap<Long, Message> messages = new ConcurrentHashMap<>();

    @Override
    public List<Message> query() {
        return new ArrayList<>(this.messages.values());
    }

    @Override
    public Message add(Message message) {
        Long id = message.getId();
        if (null == id) {
            id = counter.incrementAndGet();
            message.setId(id);
        }

        this.messages.put(id, message);
        return message;
    }

    @Override
    public Message update(Message message) {
        this.messages.put(message.getId(), message);
        return message;
    }

    @Override
    public Message updateText(Message message) {
        Message existMessage = this.messages.get(message.getId());
        existMessage.setText(message.getText());

        this.messages.put(existMessage.getId(), existMessage);
        return existMessage;
    }

    @Override
    public Message findMessage(Long id) {
        return this.messages.get(id);
    }

    @Override
    public void deleteMessage(Long id) {
        this.messages.remove(id);
    }
}
