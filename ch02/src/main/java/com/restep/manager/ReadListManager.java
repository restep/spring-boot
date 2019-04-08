package com.restep.manager;

import com.restep.entity.Book;

import java.util.List;

/**
 * @author restep
 * @date 2019/4/8
 */
public interface ReadListManager {
    List<Book> queryByReader(String reader);

    void save(Book book);
}
