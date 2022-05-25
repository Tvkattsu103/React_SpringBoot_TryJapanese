package com.tuanvo.spring.service;

import java.util.Collection;

public interface IVocabService<T> extends IService<T>{
	Collection<T> findAllByWordID(String wordID);
	
	String deleteById(Long id);
	
	T saveOrUpdate(T t);
}
