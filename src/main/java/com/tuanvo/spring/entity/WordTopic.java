package com.tuanvo.spring.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_wordtopic")
//@Table(name = "tbl_word-topic") error
public class WordTopic {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany(targetEntity = Word.class, mappedBy = "topic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Word> words;

	public WordTopic() {
		super();
	}

	public WordTopic(String name) {
		super();
		this.name = name;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
}
