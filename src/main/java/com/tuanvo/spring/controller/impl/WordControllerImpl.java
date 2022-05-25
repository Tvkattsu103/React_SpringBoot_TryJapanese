package com.tuanvo.spring.controller.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuanvo.spring.controller.Controller;
import com.tuanvo.spring.entity.Word;
import com.tuanvo.spring.service.IPageService;
import com.tuanvo.spring.service.IWordService;

@RestController
@RequestMapping("/words")
@CrossOrigin(origins="http://localhost:3000")
public class WordControllerImpl implements Controller<Word>{
	@Autowired
	private IWordService<Word> wordService;
	
	@Autowired
	private IPageService<Word> wordPageService;

	@GetMapping("/list")
	public ResponseEntity<ArrayList<Word>> findAll(){
		return new ResponseEntity<>((ArrayList<Word>)wordService.findAll(), HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Page<Word>> findAll(Pageable pageable, String searchText) {
		return new ResponseEntity<>(wordPageService.findAll(pageable, searchText), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Page<Word>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
		return new ResponseEntity<>(wordPageService.findAll(
				PageRequest.of(
						pageNumber, pageSize,
						sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()
				)
		), HttpStatus.OK);
	}
	
	@GetMapping("/topic/{topicID}")
	public ResponseEntity<Page<Word>> findWithTopic(Pageable pageable, @PathVariable Long topicID) {
		return new ResponseEntity<>(wordPageService.findWithTopic(pageable, topicID), HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<String> deleteById(Long id) {
		return new ResponseEntity<>(wordService.deleteById(id), HttpStatus.OK);
	}

	@PutMapping(value = "/changeQuantity", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Word> updateQuantity(@RequestBody Word word) {
		Word w2 = wordService.findById(word.getId()).get();
		w2.setQuantity(word.getQuantity());
		return new ResponseEntity<>(wordService.saveOrUpdate(w2), HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Word> save(@RequestBody Word word) {
		return new ResponseEntity<>(wordService.saveOrUpdate(word), HttpStatus.CREATED);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Word> update(@RequestBody Word word) {
		return new ResponseEntity<>(wordService.saveOrUpdate(word), HttpStatus.OK);
	}
}
