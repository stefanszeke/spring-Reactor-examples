package com.example.monotutorial;

import com.example.Utils.MyUtil;

import reactor.core.publisher.Mono;

public class File5MonoFromSupplier {

  public static void main(String[] args) {
    System.out.println();

    // eager -. will generate name even if no subscriber
    System.out.println("\n [ eager ]");
    Mono<String> mono1 = Mono.just(getName());


    // lazy -. will generate name only if there is a subscriber, uncomment the subscribe to see the difference
    System.out.println("\n [ lazy ]");
    Mono<String> mono2 = Mono.fromSupplier(() -> getName());
    // mono2.subscribe(
    //     MyUtil.onNext(),
    //     MyUtil.onError(),
    //     MyUtil.onComplete());
  }

  private static String getName() {
    System.out.println("-> *** Generating name..."); 
    return MyUtil.faker().name().fullName();
  }
}
