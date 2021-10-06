package com.practice.myapp;

public class BoardDto {

	private int idx;
	private String name;
	private String nickname;
	private String content;
	
	public BoardDto() {
		// TODO Auto-generated constructor stub
	}

	public BoardDto(int idx, String name, String nickname, String content) {
		super();
		this.idx = idx;
		this.name = name;
		this.nickname = nickname;
		this.content = content;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
