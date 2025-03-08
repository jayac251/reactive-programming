package io.jc.reactive.reactiveapp.subscriber;

import org.reactivestreams.Subscriber;

import org.reactivestreams.Subscription;

@Log4j2
public class SubscriberImpl implements Subscriber<String> {

    @Override
    public void onSubscribe(Subscription s) {
        // Implementation goes here
    }

    @Override
    public void onNext(String t) {
        // Implementation goes here
    }

    @Override
    public void onError(Throwable t) {
        // Implementation goes here
    }

    @Override
    public void onComplete() {
        // Implementation goes here
    }
}