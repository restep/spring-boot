package com.restep.manager.impl;

import com.restep.entity.Book;
import com.restep.mapper.ReadListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author restep
 * @date 2019/4/8
 */
@Service
public class ReadListManagerImpl implements ReadListMapper {
    @Autowired
    private ReadListMapper mapper;

    @Override
    public List<Book> queryByReader(String reader) {
        return mapper.queryByReader(reader);
    }

    @Override
    public void save(Book book) {
        mapper.save(book);
    }
}
