package com.semurr.enums;

public enum Permission {
	ROOT("root access"),
	BLOG_WRITE("write blog access");
	
	private String access;
	
	private Permission(String access){
		this.access = access;
	}
	@Override
	public String toString(){
		return access;		
	}}
