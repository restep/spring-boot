package com.restep.repository;

import com.restep.model.Message;

import java.util.List;

/**
 * @author restep
 * @date 2019/4/10
 */
public interface MessageRepository {
    List<Message> findAll();

    Message save(Message message);

    Message update(Message message);

    Message updateText(Message message);

    Message findMessage(Long id);

    void deleteMessage(Long id);
}
