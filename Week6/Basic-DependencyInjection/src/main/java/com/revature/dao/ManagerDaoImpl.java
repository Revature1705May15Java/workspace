package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Manager;
import com.revature.model.Worker;

public class ManagerDaoImpl implements Dao{
	
	static List<Manager> managerList;
	
	static{ 
		managerList = new ArrayList<>();
		managerList.add(new Manager(1, "1John","Programmer"));
		managerList.add(new Manager(2, "2Tom","MySpacing"));
		managerList.add(new Manager(3, "3Jerry","Showing Me the Money"));
	}
	public Worker findById(int id) {
		for(Manager e : managerList){
			if(e.getId() == id){
				return e;
			}
		}
		return null;
	}

}
