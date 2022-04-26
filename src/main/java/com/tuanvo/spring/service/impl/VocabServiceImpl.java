package com.tuanvo.spring.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuanvo.spring.entities.Vocab;
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
		return vocabRepository.save(vocab);
	}

	@Override
	public Collection<Vocab> findAllByWordID(String wordID) {
		return vocabRepository.findAllByWordID(Long.parseLong(wordID));
	}

}
