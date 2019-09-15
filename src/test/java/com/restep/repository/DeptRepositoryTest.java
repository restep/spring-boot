package com.restep.repository;

import com.restep.dataobject.DeptDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author restep
 * @date 2019/9/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DeptRepositoryTest {
    @Autowired
    private DeptRepository deptRepository;

    @Test
    public void save() throws Exception {
        for (int i = 1; i <= 100; i++) {
            DeptDO deptDO = new DeptDO();
            deptDO.setId(i);
            deptDO.setName("name" + i);
            deptDO.setGmtCreate(new Date());
            deptDO.setGmtModify(new Date());

            deptRepository.save(deptDO);
        }
    }

    @Test
    public void findByName() {
        DeptDO deptDO = deptRepository.findByName("name10");
        log.info("deptDO: {}", deptDO);
    }

    @Test
    public void update() {
        DeptDO deptDO = deptRepository.findById(1).get();
        deptDO.setName("修改一下");
        deptDO.setGmtModify(new Date());

        deptRepository.save(deptDO);
    }

    @Test
    public void deleteById() {
        deptRepository.deleteById(3);
    }

    @Test
    public void testPage() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(2, 10, sort);
        Page page = deptRepository.findAll(pageable);
        log.info("deptDOList: {}", page.getContent().toString());
    }
}
