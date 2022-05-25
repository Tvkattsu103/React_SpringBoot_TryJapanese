package com.tuanvo.spring.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuanvo.spring.entity.WordTopic;
import com.tuanvo.spring.repository.WordTopicRepository;
import com.tuanvo.spring.service.IWordTopicService;

@Service
public class WordTopicServiceImpl implements IWordTopicService<WordTopic>{
	@Autowired
	private WordTopicRepository wordTopicRepository;
	
	@Override
	public Collection<WordTopic> findAll() {
		return (Collection<WordTopic>) wordTopicRepository.findAll();
	}

	@Override
	public Optional<WordTopic> findById(Long id) {
		return wordTopicRepository.findById(id);
	}

	@Override
	public WordTopic saveOrUpdate(WordTopic wordTopic) {
		return wordTopicRepository.save(wordTopic);
	}

	@Override
	public WordTopic findByName(String name) {
		return wordTopicRepository.findByName(name);
	}

	@Override
	public ArrayList<WordTopic> findAll(String searchText) {
		return wordTopicRepository.findAllWords(searchText);
	}

	@Override
	public String deleteById(Long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			wordTopicRepository.deleteById(id);
			jsonObject.put("message", "User deleted successfully");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

}
