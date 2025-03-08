package io.jc.reactive.reactiveapp.subscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SubscriberImpl implements Subscriber<String> {

    private Subscription subscription;

    public Subscription getSubscription() {
        log.info("Subscriber: Getting Subscription");
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        log.info("Subscriber: Setting Subscription");
        this.subscription = subscription;
    }

    @Override
    public void onSubscribe(Subscription s) {
        log.info("Subscriber: OnSubscribe");
       this.subscription = s;
       
    }

    @Override
    public void onNext(String t) {
        log.info("Hello--- Recieved:{}",t);
    }

    @Override
    public void onError(Throwable t) {
        log.info("Hello--- Errored:{}",t);
    }

    @Override
    public void onComplete() {
        log.info("Hello--- Completed Subscription");
    }
}