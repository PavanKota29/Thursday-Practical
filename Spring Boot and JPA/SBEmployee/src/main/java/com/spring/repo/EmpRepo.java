package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.EmployeeTable;

@Repository
public interface EmpRepo extends JpaRepository<EmployeeTable, Integer> {

}
