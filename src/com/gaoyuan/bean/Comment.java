package com.gaoyuan.bean;/******************************************************************************* * javaBeans * comment --> Comment  * <table explanation> * @author 2016-09-24 20:56:56 *  */	public class Comment implements java.io.Serializable {	//field	/**  **/	private String id;	/**  **/	private String id_comment;	/**  **/	private String fromId;	/**  **/	private String fromUser;	/**  **/	private String fromDataTime;	/**  **/	private String fromHeadImg;	/**  **/	private String fromContent;	/**  **/	private String toId;	/**  **/	private String id_author;	//method	public String getId() {		return id;	}	public void setId(String id) {		this.id = id;	}	public String getId_comment() {		return id_comment;	}	public void setId_comment(String id_comment) {		this.id_comment = id_comment;	}	public String getFromId() {		return fromId;	}	public void setFromId(String fromId) {		this.fromId = fromId;	}	public String getFromUser() {		return fromUser;	}	public void setFromUser(String fromUser) {		this.fromUser = fromUser;	}	public String getFromDataTime() {		return fromDataTime;	}	public void setFromDataTime(String fromDataTime) {		this.fromDataTime = fromDataTime;	}	public String getFromHeadImg() {		return fromHeadImg;	}	public void setFromHeadImg(String fromHeadImg) {		this.fromHeadImg = fromHeadImg;	}	public String getFromContent() {		return fromContent;	}	public void setFromContent(String fromContent) {		this.fromContent = fromContent;	}	public String getToId() {		return toId;	}	public void setToId(String toId) {		this.toId = toId;	}	public String getId_author() {		return id_author;	}	public void setId_author(String id_author) {		this.id_author = id_author;	}}