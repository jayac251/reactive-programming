package io.jc.reactive.reactiveapp.publisher;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SubscriptionImpl implements Subscription{

    private Subscriber<?  super String> subscriber;
    private static final int MAX_DATA = 5;
    private int count = 0;
    private boolean isCancelled;
    
    public SubscriptionImpl(Subscriber<? super String> subscriber) {
        log.info("SubscriptionImpl: subscriber");
        this.subscriber = subscriber;
    }

    @Override
    public void request(long reqNum) {
        log.info("SubscriptionImpl: Requesting {}", reqNum);
        if (isCancelled) {
            log.info("SubscriptionImpl: Subscription is cancelled");
            return;
        }
        for (long i = 0; i < reqNum && count < MAX_DATA; i++) {
            count++;
            log.info("SubscriptionImpl: onNext");
            this.subscriber.onNext("Daily Milk Packets -" + i);
        }

        if(count == MAX_DATA) {
            log.info("SubscriptionImpl: No more data to send");
            this.subscriber.onComplete();
            this.isCancelled = true;
        }     
        
    }

    @Override
    public void cancel() {
        log.info("SubscriptionImpl: Subscriber cancelled");
        this.isCancelled = true;
       
    }
    
}
