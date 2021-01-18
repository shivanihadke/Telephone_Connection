package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.dao.TelephoneConnectionRepository;
import com.example.demo.entities.TelephoneConnection;

@SpringBootTest
@RunWith(SpringRunner.class)
class TelephoneConnectionServiceTest {

	@Autowired
	private TelephoneConnectionServiceImpl telephoneService;
	
	@MockBean
	private TelephoneConnectionRepository telephoneRepository;
	
	
	@Test
	public void GetAllConnectionTest() 
	{
		when(telephoneRepository.findAll()).thenReturn(Stream.of(
				new TelephoneConnection(98745612,10,"Shivani",23,"Nagpur","Shivali","Shivdas"),
				new TelephoneConnection(98456123,11,"Gayatri",43,"Manewada","Maya","Suraj"))
				.collect(Collectors.toList()));
		List<TelephoneConnection> tele=telephoneService.getAllConnections();
		assertEquals(2,tele.size());
	}
	
	

}
