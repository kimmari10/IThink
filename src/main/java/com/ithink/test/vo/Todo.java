package com.ithink.test.vo;

import java.sql.Date;

public class Todo {

	private String seq;
	private String title;
	private String content;
	private String success;
	private Date regdate;
	private Date dueday;
	private Date succday;
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getDueday() {
		return dueday;
	}
	public void setDueday(Date dueday) {
		this.dueday = dueday;
	}
	public Date getSuccday() {
		return succday;
	}
	public void setSuccday(Date succday) {
		this.succday = succday;
	}
	
	
	
	
	
}
