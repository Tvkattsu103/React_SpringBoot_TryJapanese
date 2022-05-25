package com.tuanvo.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_vocab")
public class Vocab {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String kanji;
	
	@Column(nullable = false)
	private String kana;
	
	@Column(nullable = false)
	private String romaji;
	
	@Column(nullable = false)
	private String meaning;
	
	@Column(nullable = false)
	private String img;
	
	@Column(nullable = false)
	private String audio;
	
	@Column(nullable = false)
	private String example;
	
	@Column(nullable = false)
	private String exampleMeaning;
	
	@Column(nullable = false)
	private String exampleImg;
	
	@Column(nullable = false)
	private String exampleAudio;
	
	public String getExampleAudio() {
		return exampleAudio;
	}

	public void setExampleAudio(String exampleAudio) {
		this.exampleAudio = exampleAudio;
	}

	@ManyToOne
	@JoinColumn(name = "word_id")
	private Word word;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKanji() {
		return kanji;
	}

	public void setKanji(String kanji) {
		this.kanji = kanji;
	}

	public String getKana() {
		return kana;
	}

	public void setKana(String kana) {
		this.kana = kana;
	}

	public String getRomaji() {
		return romaji;
	}

	public void setRomaji(String romaji) {
		this.romaji = romaji;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		this.word = word;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public String getExampleImg() {
		return exampleImg;
	}

	public void setExampleImg(String exampleImg) {
		this.exampleImg = exampleImg;
	}

	public String getExampleMeaning() {
		return exampleMeaning;
	}

	public void setExampleMeaning(String exampleMeaning) {
		this.exampleMeaning = exampleMeaning;
	}
	
}
