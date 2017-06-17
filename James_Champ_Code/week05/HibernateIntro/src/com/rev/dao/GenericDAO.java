package com.rev.dao;

import java.util.List;


public interface GenericDAO<T> {
	void create(T t);
	T getById(int id);
	List<T> getAll();
	void update(T t);
	void remove(T t);
}
