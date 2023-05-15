package com.example.monotutorial;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

import com.example.Utils.MyUtil;

import reactor.core.publisher.Mono;

public class File5MonoFromSupplier2 {

  public static void main(String[] args) {
    System.out.println();

    Supplier<String> stringSupplier = () -> getName();
    Mono<String> mono2 = Mono.fromSupplier(stringSupplier);
    mono2.subscribe(
        MyUtil.onNext(),
        MyUtil.onError(),
        MyUtil.onComplete());
  

  Callable<String> callable = () -> getName();
  Mono<String> mono3 = Mono.fromCallable(callable);
  mono3.subscribe(
      MyUtil.onNext(),
      MyUtil.onError(),
      MyUtil.onComplete());

  }

  

  private static String getName() {
    System.out.println("-> *** Generating name..."); 
    return MyUtil.faker().name().fullName();
  }
}
