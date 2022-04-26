package com.tuanvo.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tuanvo.spring.entities.Word;

@Repository
public interface WordRepository extends PagingAndSortingRepository<Word, Long> {
	@Query("FROM Word WHERE title=:title")
	Word findByTitle(@Param("title") String title);
	
	@Query("FROM Word w WHERE w.title LIKE %:searchText% ORDER BY w.title ASC")
    Page<Word> findAllWords(Pageable pageable, @Param("searchText") String searchText);
}
