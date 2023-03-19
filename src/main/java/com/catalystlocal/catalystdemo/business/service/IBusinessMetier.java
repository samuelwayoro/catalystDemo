package com.catalystlocal.catalystdemo.business.service;

import java.util.List;
import java.util.Optional;

public interface IBusinessMetier<T> {
	
	List<T> findAll();
	
	T create(T t);
	
	Optional<T> getById(Long id);
	
	int delete(Long id);
	
	int update(T t);

}
