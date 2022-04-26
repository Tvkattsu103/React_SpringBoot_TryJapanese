package com.tuanvo.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuanvo.spring.entities.WordTopic;
import com.tuanvo.spring.service.IWordTopicService;

@RestController
@RequestMapping("/topics")
@CrossOrigin(origins="http://localhost:3000")
public class WordTopicController {
	@Autowired
	private IWordTopicService<WordTopic> wordTopicService;
	
	@GetMapping("/list")
	public ResponseEntity<ArrayList<WordTopic>> findAll(){
		return new ResponseEntity<>((ArrayList<WordTopic>)wordTopicService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/search/{searchText}")
	ResponseEntity<ArrayList<WordTopic>> findAll(@PathVariable String searchText){
		return new ResponseEntity<>(wordTopicService.findAll(searchText), HttpStatus.OK);
	}
}
