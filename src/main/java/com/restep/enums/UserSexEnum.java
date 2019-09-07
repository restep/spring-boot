package com.restep.enums;

/**
 * @author restep
 * @date 2019/9/7
 */
public enum UserSexEnum {
	MAN("MAN", "男"),
	WOMAN("WOMAN", "女");

	private String code;

	private String desc;

	UserSexEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
