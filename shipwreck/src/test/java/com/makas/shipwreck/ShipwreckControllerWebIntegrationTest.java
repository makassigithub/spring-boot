package com.makas.shipwreck;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT) //test will need to redeploy App
public class ShipwreckControllerWebIntegrationTest {
	
	@Test
	public void testListAll() throws IOException{
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity <String> response = restTemplate.getForEntity("http://localhost:8080/api/v1/shipwrecks", String.class);
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode responseJson = objectMapper.readTree(response.getBody());
		
		assertThat( responseJson.isMissingNode(), is(false));
		assertThat( responseJson.toString(), equalTo("[]"));
	}

}
