package com.example.fluxtutorial;

import java.time.Duration;

import com.example.Utils.MyUtil;

import reactor.core.publisher.Flux;

public class Flux8Interval {

  public static void main(String[] args) {

    Flux.interval(Duration.ofSeconds(1))
        .subscribe(
            MyUtil.onNext(),
            MyUtil.onError(),
            MyUtil.onComplete());

    MyUtil.SleepFor(4);        
  }
}
