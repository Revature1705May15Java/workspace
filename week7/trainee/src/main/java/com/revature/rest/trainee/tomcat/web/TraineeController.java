package com.revature.rest.trainee.tomcat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.rest.trainee.tomcat.service.TraineeRepository;

// 'expose' REST API here
@RestController  // this is like having @Controller and @ResponseBody on all methods
public class TraineeController {
	@Autowired
	private TraineeRepository traineeRepostory;
	
	@RequestMapping(value = "trainee", method - RequestMethod.POST, consumes - MediaType.APPLICATIN_JSON_VALUE)
	public Trainee create(@RequestBody Trainee trainee){
		traineeRepostory.save(trainee);
		return trainee;		
	}

	@RequestMapping
	public Trainee findOne(int id){
		return traineeRepostory.findOne(id);
	}

	@RequestMapping
	public Iterable<Trainee> findAll(){
		return traineeRepostory.findAll();
	}

	@RequestMapping
	public void update(Trainee trainee){}

	@RequestMapping
	public void delete(Trainee trainee){}
}
