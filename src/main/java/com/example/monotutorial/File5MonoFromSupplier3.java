package com.example.monotutorial;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

import com.example.Utils.MyUtil;

import reactor.core.publisher.Mono;

import reactor.core.scheduler.Schedulers;

public class File5MonoFromSupplier3 {
  static int counter = 1;
  public static void main(String[] args) {
    System.out.println();


    getName(); // only build the pipeline, no subscriber
    getName(); // only build the pipeline, no subscriber
    getName(); // only build the pipeline, no subscriber, meaning no name generation

    getName()
    // .subscribeOn(Schedulers.boundedElastic()) // execute the pipeline, generate name, non-blocking the thread, uncomment to see the difference
    .subscribe( // execute the pipeline, generate name, blocking the thread
        MyUtil.onNext(),
        MyUtil.onError(),
        MyUtil.onComplete());

    // only runs after the previous pipeline is completed
    getName();

    MyUtil.SleepFor(5);

  }

  private static Mono<String> getName() {
    System.out.println("-> **** "+ counter++ +". Requesting name generation...");
    return Mono.fromSupplier(() -> {
      System.out.println(" -> *** Generating name ...");
      MyUtil.SleepFor(2);
      return MyUtil.faker().name().fullName();
    }).map(str -> str.toUpperCase());
  }
}
