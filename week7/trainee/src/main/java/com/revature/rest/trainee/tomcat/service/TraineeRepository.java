package com.revature.rest.trainee.tomcat.service;

import org.springframework.data.repository.CrudRepository;

import com.revature.rest.trainee.tomcat.web.Trainee;

public interface TraineeRepository extends CrudRepository<Trainee, Integer> {
	@Override
	Trainee findOne(Integer id);
	
	@Override
	Iterable<Trainee> findAll();
	
	@Override
	void delete(Integer arg0);
	
	@Override
	<S extends Trainee> S save(S Trainee);
}
