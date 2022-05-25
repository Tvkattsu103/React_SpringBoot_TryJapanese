package com.tuanvo.spring.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tuanvo.spring.entity.User;
import com.tuanvo.spring.repository.UserRepository;
import com.tuanvo.spring.service.IPageService;
import com.tuanvo.spring.service.IService;

@Service
public class UserServiceImpl implements IService<User>, IPageService<User> {
	@Autowired
	private UserRepository userRepository;

	@Override
	public Collection<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public User saveOrUpdate(User user) {
		return userRepository.saveAndFlush(user);
	}

	@Override
	public String deleteById(Long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			userRepository.deleteById(id);
			jsonObject.put("message", "User deleted successfully");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	@Override
	public Page<User> findAll(Pageable pageable, String searchText) {
		return userRepository.findAllUsers(pageable, searchText);
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public Page<User> findWithTopic(Pageable pageable, Long topicID) {
		return null;
	}
}
