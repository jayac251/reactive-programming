package io.jc.reactive.reactiveapp;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.SpringApplication;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class ReactiveappApplicationTest {

	@MockBean
	private SpringApplication springApplication;

	@Test
	void contextLoads() {
		// Test to ensure the Spring application context loads successfully
	}

	@Test
	void testMain() {
		ReactiveappApplication.main(new String[] {});
		verify(springApplication, times(1)).run(ReactiveappApplication.class, new String[] {});
	}
}