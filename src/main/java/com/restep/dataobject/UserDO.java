package com.restep.dataobject;

import com.restep.enums.UserSexEnum;
import lombok.Data;

/**
 * @author restep
 * @date 2019/9/7
 */
@Data
public class UserDO {
	private Integer id;

	private String username;

	private String password;

	private UserSexEnum userSex;

	private String nickname;
}