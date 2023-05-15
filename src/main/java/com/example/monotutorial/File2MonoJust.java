package com.example.monotutorial;

import reactor.core.publisher.Mono;

public class File2MonoJust {
  public static void main(String[] args) {
    
    // publisher
    Mono<Integer> mono = Mono.just(1);

    // subscriber
    mono.subscribe(data -> System.out.println(data));

    System.out.println("done");
  }
  
}
