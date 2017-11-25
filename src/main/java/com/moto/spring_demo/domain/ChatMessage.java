package com.moto.spring_demo.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="chat_message")
public class ChatMessage extends BaseEntity  {


    private String content;
    private String sender;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
