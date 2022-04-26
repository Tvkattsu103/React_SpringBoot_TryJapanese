package com.tuanvo.spring.controller.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuanvo.spring.controller.Controller;
import com.tuanvo.spring.entities.Word;
import com.tuanvo.spring.service.IPageService;
import com.tuanvo.spring.service.IService;

@RestController
@RequestMapping("/words")
@CrossOrigin(origins="http://localhost:3000")
public class WordControllerImpl implements Controller<Word>{
	@Autowired
	private IService<Word> wordService;
	
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
}
