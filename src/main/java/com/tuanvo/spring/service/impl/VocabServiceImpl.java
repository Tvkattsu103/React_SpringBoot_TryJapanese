package com.tuanvo.spring.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuanvo.spring.entity.Vocab;
import com.tuanvo.spring.repository.VocabRepository;
import com.tuanvo.spring.service.IVocabService;

@Service
public class VocabServiceImpl implements IVocabService<Vocab>{
	@Autowired
	private VocabRepository vocabRepository;
	
	@Override
	public Collection<Vocab> findAll() {
		return (Collection<Vocab>) vocabRepository.findAll();
	}

	@Override
	public Optional<Vocab> findById(Long id) {
		return vocabRepository.findById(id);
	}
	
	@Override
	public Vocab saveOrUpdate(Vocab vocab) {
		return vocabRepository.saveAndFlush(vocab);
	}

	@Override
	public Collection<Vocab> findAllByWordID(String wordID) {
		return vocabRepository.findAllByWordID(Long.parseLong(wordID));
	}

	@Override
	public String deleteById(Long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			vocabRepository.deleteById(id);
			jsonObject.put("message", "Vocab deleted successfully");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
}
