package com.restep.controller;

import com.restep.manager.ReadListManager;
import com.restep.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import java.util.List;

/**
 * @author restep
 * @date 2019/4/8
 */
@Controller
@RequestMapping("/readList")
public class ReadListController {
    @Autowired
    private ReadListManager readListManager;

    private static final String READER = "restep";

    @RequestMapping(method = RequestMethod.GET)
    public String readList(Model model) {
        List<Book> readingList = readListManager.queryByReader(READER);
        if (null != readingList) {
            model.addAttribute("books", readingList);
        }

        return "readList";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(Book book) {
        book.setReader(READER);
        readListManager.save(book);

        return UrlBasedViewResolver.REDIRECT_URL_PREFIX + "/readList";
    }
}
