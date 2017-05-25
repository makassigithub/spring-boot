package com.makas.shipwreck;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.Assert.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.makas.shipwreck.controller.ShipwreckController;
import com.makas.shipwreck.model.Shipwreck;
import com.makas.shipwreck.repository.ShipwreckRepository;

public class ShipwreckControllerTest {
	
	//Use mock to inject an instance of Shipwreckcontroller
	@InjectMocks
	private ShipwreckController sc;
	
	//Create a Mock object of a shipwreckRepository
	@Mock
	private ShipwreckRepository shipwreckRepository;
	
	//Activate Mockito annotations before the test starts
	//This wires up beans injected using othet @s (DI)
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
    @Test
	public void TestShipwreckController() {
	 Shipwreck wreck = new Shipwreck();
	           wreck.setId(1L);
	 //Because I am not using a database i use a Mokito STUB
	 when(shipwreckRepository.findOne(1L)).thenReturn(wreck);
	 assertEquals(1L,wreck.getId().longValue());
	 
	 //I can optionally verified if shipwreckRepository really gets called
	 //verify(shipwreckRepository).findOne(1l);
	 
	 //I can also use Harmcrest assert that is more declarative than junit
	 assertThat(wreck.getId(), is(1L));
	}
}
