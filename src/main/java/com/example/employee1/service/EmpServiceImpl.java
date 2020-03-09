package com.example.employee1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.employee1.entity.EmpEntity;
import com.example.employee1.exception.RecordNotFoundException;
import com.example.employee1.repository.EmpRepository;

@Component
public class EmpServiceImpl implements EmpService {
	
	 @Autowired
	    EmpRepository repository;
	     
	    public List<EmpEntity> getAllEmployees()
	    {
	        List<EmpEntity> employeeList = repository.findAll();
	         
	        if(employeeList.size() > 0) {
	            return employeeList;
	        } else {
	            return new ArrayList<EmpEntity>();
	        }
	    }
	     
	    public EmpEntity getEmployeeById(Integer id) throws RecordNotFoundException
	    {
	        Optional<EmpEntity> employee = repository.findById(id);
	         
	        if(employee.isPresent()) {
	            return employee.get();
	        } else {
	            throw new RecordNotFoundException("No employee record exist for given id");
	        }
	    }
	     
	    public EmpEntity createOrUpdateEmployee(EmpEntity entity) throws RecordNotFoundException 
	    {
	        Optional<EmpEntity> employee = repository.findById(entity.getId());
	         
	        if(employee.isPresent()) 
	        {
	            EmpEntity newEntity = employee.get();

	            newEntity.setName(entity.getName());
	            newEntity.setSalary(entity.getSalary());
	            newEntity.setEmail(entity.getEmail());
	 
	            newEntity = repository.save(newEntity);
	             
	            return newEntity;
	        } else {
	            entity = repository.save(entity);
	             
	            return entity;
	        }
	    } 
	     
		@Override
		public void  deleteByEmployeeId(Integer id) throws RecordNotFoundException {
			  Optional<EmpEntity> employee = repository.findById(id);
		         System.out.println(employee.get());
		        if(employee.isPresent()) 
		        {
		            repository.deleteById(id);
		        } else {
		            throw new RecordNotFoundException("No employee record exist for given id");
		        }
		}

}
