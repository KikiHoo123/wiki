package com.bsc.modules.mail.entity;
import com.bsc.common.persistence.BaseEntity;
import com.bsc.modules.user.entity.User;

public class Mail extends BaseEntity {
    private User sender;
    private User receiver;
    private String time;
    private String content;

    public User getSender() { return sender; }
    public void setSender(User sender) { this.sender = sender; }

    public User getReceiver() { return receiver; }
    public void setReceiver(User receiver) { this.receiver = receiver; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

}

