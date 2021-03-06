package com.restep.controller;

import com.restep.dataobject.MessageDO;
import com.restep.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author restep
 * @date 2019/9/1
 */
@RestController
@Slf4j
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping(value = "/messages")
    public List<MessageDO> list() {
        log.info("查询列表");
        return messageRepository.query();
    }

    @PostMapping(value = "/message")
    public MessageDO add(@RequestBody MessageDO message) {
        log.info("新增message:{}", message);
        return messageRepository.add(message);
    }

    @PutMapping(value = "/message")
    public MessageDO update(@RequestBody MessageDO message) {
        log.info("修改message:{}", message);
        return messageRepository.update(message);
    }

    @PatchMapping("/message/text")
    public MessageDO patch(@RequestBody MessageDO message) {
        log.info("部分修改message:{}", message);
        return messageRepository.updateText(message);
    }

    @GetMapping(value = "/message/{id}")
    public MessageDO detail(@PathVariable Long id) {
        log.info("查看详情id:{}", id);
        return messageRepository.findMessage(id);
    }

    @DeleteMapping(value = "/message/{id}")
    public void delete(@PathVariable("id") Long id) {
        log.info("删除id:{}", id);
        messageRepository.deleteMessage(id);
    }
}
