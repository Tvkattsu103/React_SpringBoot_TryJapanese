package com.tuanvo.spring.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tuanvo.spring.entities.Vocab;

@Repository
public interface VocabRepository extends JpaRepository<Vocab, Long>{
	@Query("FROM Vocab v WHERE v.word.id=:wordID")
	ArrayList<Vocab> findAllByWordID(@Param("wordID") Long wordID);
}
