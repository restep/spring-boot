package com.restep.dataobject;

import lombok.Data;

import java.io.Serializable;

/**
 * @author restep
 * @date 2019/9/7
 */
@Data
public class UserDO implements Serializable {
	private static final long serialVersionUID = 5636629124765650956L;

	private Integer id;

	private String username;

	private String password;

	private String userSex;

	private String nickname;
}