package com.test.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.RequestFormEntity;

@Repository
public interface RequestFormRepository extends CrudRepository<RequestFormEntity, Integer> {

	List<RequestFormEntity> findByFirstNameAndLastName(String fname, String lname);

}
