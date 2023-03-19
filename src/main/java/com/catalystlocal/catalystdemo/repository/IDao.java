package com.catalystlocal.catalystdemo.repository;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {
	
	List<T> findAll();
	
	T create(T t);
	
	Optional<T> getById(Long id);
	
	int update (T t);
	
	int delete(Long id);
	

}
