package com.handson.springhandsonthree;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringhandsonthreeApplicationTests {

	@Test
	void contextLoads() {
		Logger logger = LoggerFactory.getLogger(SpringhandsonthreeApplicationTests.class);
		logger.info("SUCCESS");
	}

}
