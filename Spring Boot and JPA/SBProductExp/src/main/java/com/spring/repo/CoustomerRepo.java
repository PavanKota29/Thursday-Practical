package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Coustomer;

@Repository
public interface CoustomerRepo extends JpaRepository<Coustomer, Integer> {

}
