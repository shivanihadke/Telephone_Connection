package com.example.demo.controller;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.TelephoneConnectionApplication;
import com.example.demo.entities.TelephoneConnection;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TelephoneConnectionApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TelephoneConnectionControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllConnection() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/getallconnection",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetConnectionById() {
		TelephoneConnection telephone = restTemplate.getForObject(getRootUrl() + "/1", TelephoneConnection.class);
		System.out.println(telephone.getCitizenName());
		assertNotNull(telephone);
	}

	@Test
	public void testCreateNewConnection() {
		TelephoneConnection telephone = new TelephoneConnection();
		telephone.setCitizenName("Harsh");
		telephone.setCitizenAge(20);
		telephone.setCitizenAddress("Patna");

		ResponseEntity<TelephoneConnection> postResponse = restTemplate.postForEntity(getRootUrl() + "/createnewconnection", telephone, TelephoneConnection.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	

}
