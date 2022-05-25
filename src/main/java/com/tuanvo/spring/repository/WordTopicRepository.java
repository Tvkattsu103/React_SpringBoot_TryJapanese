package com.tuanvo.spring.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tuanvo.spring.entity.WordTopic;

@Repository
public interface WordTopicRepository extends JpaRepository<WordTopic, Long>{
	@Query("FROM WordTopic WHERE name=:name")
	WordTopic findByName(@Param("name") String name);
	
	@Query("FROM WordTopic WHERE name LIKE %:searchText% ORDER BY name ASC")
    ArrayList<WordTopic> findAllWords(@Param("searchText") String searchText);
}
