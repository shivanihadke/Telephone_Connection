package com.example.demo.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.entities.TelephoneConnection;

@DataJpaTest
@RunWith(SpringRunner.class)

class TelephoneConnectionRepositoryTest {
	
	@Autowired
	private TelephoneConnectionRepository telephoneRepository;
	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	void setUp() throws Exception {
		entityManager.persist(new TelephoneConnection(985476123,1,"Sony", 19,"Hungary","Shital","Yash"));
		entityManager.persist(new TelephoneConnection(984125637,2,"Sam",25,"Hungary","Shital","Yash"));
		entityManager.persist(new TelephoneConnection(984561273,3,"Niki", 26,"Hungary","Shital","Yash"));
		entityManager.persist(new TelephoneConnection(988541762,4,"Ben", 35,"Hungary","Shital","Yash"));
		entityManager.persist(new TelephoneConnection(932576145,5,"Lala",52,"Hungary","Shital","Yash"));
	}
	

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreateNewConnection() {
		TelephoneConnection saveInDb = entityManager.persist(new TelephoneConnection(956874123,1,"Sony", 19,"Hungary","Shital","Yash"));
		System.out.println(saveInDb);
		assertThat(saveInDb.getCitizenId()).isEqualTo(1);
	}
	@Test
	public void testGetAllConnection() {
		List<TelephoneConnection> tele = (List<TelephoneConnection>) telephoneRepository.findAll();
		assertThat(tele, hasSize(5));
		assertThat(tele.size(),is(5));
	}

}
