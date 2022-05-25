package com.tuanvo.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuanvo.spring.entity.Vocab;
import com.tuanvo.spring.service.IVocabService;

@RestController
@RequestMapping("/vocab")
@CrossOrigin(origins="http://localhost:3000")
public class VocabController {
	@Autowired
	private IVocabService<Vocab> vocabService;
	
	@GetMapping("/list")
	public ResponseEntity<ArrayList<Vocab>> findAll(){
		return new ResponseEntity<>((ArrayList<Vocab>)vocabService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{vocabID}")
	ResponseEntity<ArrayList<Vocab>> findAllByWordID(@PathVariable String vocabID){
		System.out.println(vocabID);
		return new ResponseEntity<>((ArrayList<Vocab>)vocabService.findAllByWordID(vocabID), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		return new ResponseEntity<>(vocabService.deleteById(id), HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Vocab> save(@RequestBody Vocab vocab) {
		return new ResponseEntity<>(vocabService.saveOrUpdate(vocab), HttpStatus.CREATED);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Vocab> update(@RequestBody Vocab vocab) {
		return new ResponseEntity<>(vocabService.saveOrUpdate(vocab), HttpStatus.OK);
	}
}
