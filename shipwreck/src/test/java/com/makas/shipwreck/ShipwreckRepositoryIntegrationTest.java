package com.makas.shipwreck;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.makas.shipwreck.model.Shipwreck;
import com.makas.shipwreck.repository.ShipwreckRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class) //test will need to redeploy App
@WebAppConfiguration //This helps with the autowiring
public class ShipwreckRepositoryIntegrationTest {
	@Autowired
	ShipwreckRepository shipwreckRepository;
	
	@Test
	public void testFindAll() {
		List<Shipwreck> wrecks = shipwreckRepository.findAll();
		assertThat(wrecks.size(), is(greaterThanOrEqualTo(0)));
	}

}
