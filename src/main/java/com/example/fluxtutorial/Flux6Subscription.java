package com.example.fluxtutorial;

import java.util.concurrent.atomic.AtomicReference;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import com.example.Utils.MyUtil;

import reactor.core.publisher.Flux;

public class Flux6Subscription {

  public static void main(String[] args) {

    AtomicReference<Subscription> ar = new AtomicReference<>();

    Flux.range(1, 10)
        .map(i -> MyUtil.faker().name().fullName())
        .log()
        .subscribeWith(new Subscriber<String>() {

          @Override
          public void onComplete() {
            System.out.println("onComplete");
          }

          @Override
          public void onError(Throwable arg0) {
            System.out.println("onError: " + arg0.getMessage());
          }

          @Override
          public void onNext(String arg0) {
            System.out.println("onNext: " + arg0);
            ar.get().request(1);
          }

          @Override
          public void onSubscribe(Subscription arg0) {
            System.out.println("Subscribed:" + arg0);
            ar.set(arg0);
          }

        });

        MyUtil.SleepFor(3);

        ar.get().request(2);

        MyUtil.SleepFor(5);

        ar.get().request(2);

        MyUtil.SleepFor(5);

        System.out.println("Canceling subscription");
        ar.get().cancel();
  }
}
