package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.MyEmployee;

public interface EmpRepo extends JpaRepository<MyEmployee, Integer>{

}
