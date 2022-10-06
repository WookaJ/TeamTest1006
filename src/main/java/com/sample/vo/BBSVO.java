package com.sample.vo;

import org.apache.ibatis.type.Alias;

@Alias("BBSVO")
public class BBSVO {
	private int id;
	private String category;
	private String title;
	private int ownerId;
	private String owner;
	private String content;
	private String createDate;
	public BBSVO() {
		// TODO Auto-generated constructor stub
	}
	
	public BBSVO(int id, String category, String title, int ownerId, String owner, String content, String createDate) {
		super();
		this.id = id;
		this.category = category;
		this.title = title;
		this.ownerId = ownerId;
		this.owner = owner;
		this.content = content;
		this.createDate = createDate;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
			
}
