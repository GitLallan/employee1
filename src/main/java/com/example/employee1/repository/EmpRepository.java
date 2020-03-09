package com.example.employee1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee1.entity.EmpEntity;

public interface EmpRepository extends JpaRepository<EmpEntity, Integer> {

}
