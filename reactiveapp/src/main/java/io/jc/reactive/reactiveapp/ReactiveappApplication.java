package io.jc.reactive.reactiveapp;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.jc.reactive.reactiveapp.publisher.PublisherImpl;
import io.jc.reactive.reactiveapp.subscriber.SubscriberImpl;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class ReactiveappApplication {

	public static void main(String[] args) {

		SpringApplication.run(ReactiveappApplication.class, args);
		log.info("Reactive Programming with Spring Boot");
		demo2();

	}

	public static void demo1() {
		PublisherImpl publisher = new PublisherImpl();
		SubscriberImpl subscriber = new SubscriberImpl();
		publisher.subscribe(subscriber);
	}

	public static void demo2() {
		PublisherImpl publisher = new PublisherImpl();
		SubscriberImpl subscriber = new SubscriberImpl();
		publisher.subscribe(subscriber);
		try {
			log.info("\n\n\nRequesting 2 items");
			subscriber.getSubscription().request(2);
			Thread.sleep(5000);
			log.info("\n\n\nRequesting 1 item");
			subscriber.getSubscription().request(1);
			Thread.sleep(5000);
			log.info("\n\n\nRequesting 6 items");
			subscriber.getSubscription().request(6);
			Thread.sleep(5000);
			log.info("\n\n\nRequesting 4 items");
			subscriber.getSubscription().request(4);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
