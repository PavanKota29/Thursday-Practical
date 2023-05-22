package com.spring.repo;

import org.springframework.data.repository.CrudRepository;

import com.spring.entity.Stud;

public interface StudRepo extends CrudRepository<Stud, Integer> {

}
