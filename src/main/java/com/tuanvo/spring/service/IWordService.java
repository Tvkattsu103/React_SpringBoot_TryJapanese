package com.tuanvo.spring.service;

public interface IWordService<T> extends IService<T>{
	T findByTitle(String title);
	
	String deleteById(Long id);
	
	String updateQuantity(Integer quantity, Long id);
}
