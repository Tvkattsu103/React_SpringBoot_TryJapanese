package com.tuanvo.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tuanvo.spring.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("FROM User WHERE email=:email")
	User findByEmail(@Param("email") String email);
	
	@Query("FROM User u WHERE u.name LIKE %:searchText% OR u.email LIKE %:searchText% OR u.mobile LIKE %:searchText% ORDER BY u.name ASC")
    Page<User> findAllUsers(Pageable pageable, @Param("searchText") String searchText);
}
