package com.tuanvo.spring.service;

public interface IWordService<T> extends IService<T>{
	T findByTitle(String title);
}
