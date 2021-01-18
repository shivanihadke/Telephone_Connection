package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.TelephoneConnection;
@Repository
public interface TelephoneConnectionRepository extends CrudRepository<TelephoneConnection,Integer>{

	

	

}
