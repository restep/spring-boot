package com.restep.mapper;

import com.restep.entity.Book;

import java.util.List;

/**
 * @author restep
 * @date 2019/4/8
 */
public interface ReadListMapper {
    List<Book> queryByReader(String reader);

    void save(Book book);
}
