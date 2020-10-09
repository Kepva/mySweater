package com.example.sweater.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.sweater.service.ChatMessage;

public interface ChatMessageRepo extends CrudRepository<ChatMessage, Long> {

    List<ChatMessage> findByTag(String tag);

}
