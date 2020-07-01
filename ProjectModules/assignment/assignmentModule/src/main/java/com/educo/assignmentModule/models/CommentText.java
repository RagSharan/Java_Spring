package com.educo.assignmentModule.models;

import java.util.Date;

public class CommentText {
	
	private String sender;
	private Date textTiming;
	private String messageText;
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public Date getTextTiming() {
		return textTiming;
	}
	public void setTextTiming(Date textTiming) {
		this.textTiming = textTiming;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	
	

}
