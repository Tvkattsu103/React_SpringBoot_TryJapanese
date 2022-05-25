package com.tuanvo.spring.service;

public interface IRoleService<T> extends IService<T> {
	T findByName(String name);
}
