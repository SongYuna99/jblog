package com.poscodx.jblog.vo;

public class UserVo {
	private String id;
	private String name;
	private String password;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
