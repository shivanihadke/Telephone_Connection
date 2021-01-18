package com.example.demo.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TelephoneConnectionRepository;
import com.example.demo.entities.TelephoneConnection;

@Service
public  class TelephoneConnectionServiceImpl implements ITelephoneConnectionService{

	@Autowired
	private TelephoneConnectionRepository telephoneRepository;

	@Override
	public Integer createNewTelephoneConnection(TelephoneConnection telephone) 
	{
		Random r=new Random();
		telephone.setCitizenPhoneNumber(Math.abs(r.nextInt()));
		TelephoneConnection telephone1=telephoneRepository.save(telephone);
		return telephone1.getCitizenPhoneNumber();
	}

	@Override
	public List<TelephoneConnection> getAllConnections() {
		List<TelephoneConnection> getAllConnections=(List<TelephoneConnection>) telephoneRepository.findAll();
		return getAllConnections;
	}


}
	
