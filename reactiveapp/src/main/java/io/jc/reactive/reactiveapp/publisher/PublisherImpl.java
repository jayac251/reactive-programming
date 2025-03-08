package io.jc.reactive.reactiveapp.publisher;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class PublisherImpl implements Publisher<String> {
        @Override
        public void subscribe(Subscriber<? super String> subscriber) {
            log.info("Publisher: onSubscribe");
            subscriber.onSubscribe(new SubscriptionImpl(subscriber));
        }
    }
    

