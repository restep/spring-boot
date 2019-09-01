package com.restep.repository;

import com.restep.dataobject.Message;

import java.util.List;

/**
 * @author restep
 * @date 2019/9/1
 */
public interface MessageRepository {
    List<Message> query();

    Message add(Message message);

    Message update(Message message);

    Message updateText(Message message);

    Message findMessage(Long id);

    void deleteMessage(Long id);
}
