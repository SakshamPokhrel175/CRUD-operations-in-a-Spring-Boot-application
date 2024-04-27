package com.saksham.Springboottest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService {

	@Autowired
	StudentRepo repo;    
	
	public List<Student> showData()
	{
		return repo.findAll();
	}
	
	public Student addNewData(Student stu)
	{
		return repo.save(stu);
	}


	public  Student get(int id) {
		return repo.findById(id).get();
	}
	
	
	public void delete(int id)
	{
		repo.deleteById(id);
	}

	

}

	
	