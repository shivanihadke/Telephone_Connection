package com.example.demo.controller;
import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.TelephoneConnectionRepository;
import com.example.demo.entities.TelephoneConnection;
import com.example.demo.exception.TelephoneConnectionNotFoundException;
import com.example.demo.service.ITelephoneConnectionService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@Validated
@RequestMapping(value = "/react")
public class TelephoneConnectionController {
	
	@Autowired
	private ITelephoneConnectionService telephoneService;
	
	@Autowired
	private TelephoneConnectionRepository telephoneRepository;
	
	// Save Operation
		@PostMapping("/telephones")
		@ResponseStatus(HttpStatus.CREATED)
		public ResponseEntity<String> createNewTelephoneConnection(@Valid @RequestBody TelephoneConnection newTelephoneConnection) 
		{
		Integer citizenPhoneNumber=telephoneService.createNewTelephoneConnection(newTelephoneConnection);
		return new ResponseEntity<String>("Telephone Connection Established Successfully. Your New Telephone Number is: "+citizenPhoneNumber,HttpStatus.OK);
		}
		
		// Fetching All Connections
		@GetMapping("/telephones")
		public List<TelephoneConnection> findAll() 
		{
		return telephoneService.getAllConnections();
		}
		
		@GetMapping("/telephones/{id}")
		public ResponseEntity<TelephoneConnection> getConnectionById(@PathVariable(value = "id") int citizenId)
				throws TelephoneConnectionNotFoundException {
			TelephoneConnection telephone = telephoneRepository.findById((int) citizenId)
					.orElseThrow(() -> new TelephoneConnectionNotFoundException("Telephone Connection for citizen id: " + citizenId+" is not available."));
			return ResponseEntity.ok().body(telephone);
		}
				
}


		
