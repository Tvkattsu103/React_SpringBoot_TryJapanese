package com.tuanvo.spring.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tuanvo.spring.entities.Word;
import com.tuanvo.spring.repository.WordRepository;
import com.tuanvo.spring.service.IPageService;
import com.tuanvo.spring.service.IWordService;

@Service
public class WordServiceImpl implements IWordService<Word>, IPageService<Word> {
	@Autowired
	private WordRepository wordRepository;
	
	@Override
	public Collection<Word> findAll() {
		return (Collection<Word>) wordRepository.findAll();
	}

	@Override
	public Page<Word> findAll(Pageable pageable, String searchText) {
		return wordRepository.findAllWords(pageable, searchText);
	}
	
	@Override
	public Page<Word> findAll(Pageable pageable) {
		return wordRepository.findAll(pageable);
	}
	
	@Override
	public Optional<Word> findById(Long id) {
		return wordRepository.findById(id);
	}

	@Override
	public Word saveOrUpdate(Word word) {
		return wordRepository.save(word);
	}
	
	public Word findByTitle(String title) {
		return wordRepository.findByTitle(title);
	}
}
