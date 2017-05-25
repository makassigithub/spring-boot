package com.makas.shipwreck;

import static org.junit.Assert.assertEquals;

import com.makas.shipwreck.controller.HelloController;
import org.junit.Test;


public class HelloControllerTest {


   @Test
   public void TestHomePage(){
	   HelloController hello_c = new HelloController();
	   String result = hello_c.SayHello();
	   assertEquals(result,"Entrance point of the my Application");
   }
}
