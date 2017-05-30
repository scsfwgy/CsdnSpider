package com.gaoyuan.bean;

/**
 * @author 高远</n>
 * 编写日期   2016-11-12下午7:18:33</n>
 * 邮箱  wgyscsf@163.com</n>
 * 博客  http://blog.csdn.net/wgyscsf</n>
 * TODO</n>
 */
public class User {
	private String id;
	private String id_user;
	private String createTime;

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", id_user=" + id_user + ", createTime="
				+ createTime + "]";
	}


}
