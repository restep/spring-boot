package com.restep.req;

import lombok.Data;

@Data
public class UserReq extends PageReq {
    private String username;

    private String userSex;
}
