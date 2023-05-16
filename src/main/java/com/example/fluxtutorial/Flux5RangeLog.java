package com.example.fluxtutorial;

import com.example.Utils.MyUtil;

import reactor.core.publisher.Flux;

public class Flux5RangeLog {

  public static void main(String[] args) {
    MyUtil.SleepFor(1);
    System.out.println();

    Flux.range(1, 10)
        .log()
        .map(i -> i + ": " + MyUtil.faker().name().fullName())
        .log()
        .subscribe(
            MyUtil.onNext(),
            MyUtil.onError(),
            MyUtil.onComplete());
  }
}
