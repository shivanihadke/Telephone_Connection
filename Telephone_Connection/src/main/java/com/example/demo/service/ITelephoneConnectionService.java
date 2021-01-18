package com.example.demo.service;

import com.example.demo.entities.TelephoneConnection;



import java.util.List;

public interface ITelephoneConnectionService {
	
	public Integer createNewTelephoneConnection(TelephoneConnection telephone);
	public List<TelephoneConnection> getAllConnections() ;
	
	
	

}
