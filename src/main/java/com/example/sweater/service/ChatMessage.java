package com.example.sweater.service;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.sweater.domain.User;


@Entity
public class ChatMessage {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
    private MessageType type;
    private String content;
    private String roomID;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User sender;

    public ChatMessage() {
    }
    
    public ChatMessage(String text) {
        this.content = text;
        
    }
    
    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    public String getSenderName() {
        return sender != null ? sender.getUsername() : "<none>";
    }
    
    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
