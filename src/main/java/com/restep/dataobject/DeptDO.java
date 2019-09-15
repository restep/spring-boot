package com.restep.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * @author restep
 * @date 2019/9/15
 */
@Data
public class DeptDO {
    private Integer id;

    private String name;

    private Date gmtCreate;

    private Date gmtModify;
}
