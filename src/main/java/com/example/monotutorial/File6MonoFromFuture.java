package com.example.monotutorial;

import java.util.concurrent.CompletableFuture;

import com.example.Utils.MyUtil;

import reactor.core.publisher.Mono;

public class File6MonoFromFuture {

  public static void main(String[] args) {

    Mono.fromFuture(getName()).subscribe(
        MyUtil.onNext(),
        MyUtil.onError(),
        MyUtil.onComplete());

    MyUtil.SleepFor(1);
  }

  private static CompletableFuture<String> getName() {
    return CompletableFuture.supplyAsync(() -> {
      System.out.println("-> *** Generating name...");
      return MyUtil.faker().name().fullName();
    });
  }
}
