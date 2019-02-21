package com.lidong;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {

	@Autowired
	private MessageServiceImpl messageService;

	@Test
	public void contextLoads() {
	}


	@Test
	public void send() {
		messageService.sendMsg("test_queue_1","hello i am delay msg");


	}

}
