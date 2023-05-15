package com.example.monotutorial;

import com.example.Utils.MyUtil;

import reactor.core.publisher.Mono;

public class File7MonoFromRunnable {

  public static void main(String[] args) {

    Mono.fromRunnable(timeConsumingProcess()).subscribe(
        MyUtil.onNext(),
        MyUtil.onError(),
        () -> System.out.println("-> onComplete completed ...")); // run after runnable completes
  }

  private static Runnable timeConsumingProcess() {
    return () -> {
      MyUtil.SleepFor(3);
      System.out.println("-> operation completed ...");
    };
  }

}
