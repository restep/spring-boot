package com.restep.repository;

import com.restep.dataobject.MessageDO;

import java.util.List;

/**
 * @author restep
 * @date 2019/9/1
 */
public interface MessageRepository {
    List<MessageDO> query();

    MessageDO add(MessageDO message);

    MessageDO update(MessageDO message);

    MessageDO updateText(MessageDO message);

    MessageDO findMessage(Long id);

    void deleteMessage(Long id);
}
