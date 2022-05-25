package com.tuanvo.spring.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPageService<T> {
	Page<T> findAll(Pageable pageable, String searchText);

	Page<T> findAll(Pageable pageable);
	
	Page<T> findWithTopic(Pageable pageable, Long topicID);
	
}
