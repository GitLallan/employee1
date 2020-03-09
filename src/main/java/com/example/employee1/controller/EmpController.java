package com.example.employee1.controller;


import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee1.entity.EmpEntity;
import com.example.employee1.exception.RecordNotFoundException;
import com.example.employee1.service.EmpService;

@RestController
@RequestMapping("/employees")
public class EmpController {
	
	 @Autowired
	    EmpService service;
	 
	    @GetMapping
	    public ResponseEntity<List<EmpEntity>> getAllEmployees() {
	        List<EmpEntity> list = service.getAllEmployees();
	 
	        return new ResponseEntity<List<EmpEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	    @GetMapping("/{id}")
	    public ResponseEntity<EmpEntity> getEmployeeById(@PathVariable("id") Integer id) 
	                                                    throws RecordNotFoundException {
	        EmpEntity entity = service.getEmployeeById(id);
	 
	        return new ResponseEntity<EmpEntity>(entity, new HttpHeaders(),    HttpStatus.OK);
	    }
	 
	    @PostMapping
	    public ResponseEntity<EmpEntity> createOrUpdateEmployee(@RequestBody EmpEntity employee)
	                                                    throws RecordNotFoundException {
	        EmpEntity updated = service.createOrUpdateEmployee(employee);
	        return new ResponseEntity<EmpEntity>(updated,  new HttpHeaders(), HttpStatus.OK);
	    }
	 
	    @DeleteMapping("/{id}")
	    public HttpStatus deleteEmployeeById(@PathVariable("id") Integer id) 
	                                                    throws RecordNotFoundException {
	        service.deleteByEmployeeId(id);
	        return HttpStatus.FORBIDDEN;
	    }

}
