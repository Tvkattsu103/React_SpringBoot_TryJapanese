package com.tuanvo.spring.service;

import java.util.ArrayList;

public interface IWordTopicService<T> extends IService<T>{
	T findByName(String name);
	
	ArrayList<T> findAll(String searchText);
}
