package com.example.employee1.service;

import java.util.List;

import com.example.employee1.entity.EmpEntity;
import com.example.employee1.exception.RecordNotFoundException;

public interface EmpService {
	
	 public List<EmpEntity> getAllEmployees();
	
	 public EmpEntity getEmployeeById(Integer id) throws RecordNotFoundException;
	
	public EmpEntity createOrUpdateEmployee(EmpEntity  entity) throws RecordNotFoundException;
	
	public void deleteByEmployeeId(Integer id) throws RecordNotFoundException;

}
