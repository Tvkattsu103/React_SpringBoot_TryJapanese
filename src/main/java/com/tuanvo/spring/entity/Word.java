package com.tuanvo.spring.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_word")
public class Word {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String photoURL;
	
	@Column(nullable = false)
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "topic_id")
	private WordTopic topic;
	
	@OneToMany(targetEntity = Vocab.class, mappedBy = "word", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Vocab> vocabs;

	
	public Word() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public Integer getQuantity() {
		return quantity;
	}
	
	

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public WordTopic getTopic() {
		return topic;
	}

	public void setTopic(WordTopic topic) {
		this.topic = topic;
	}
	
}
