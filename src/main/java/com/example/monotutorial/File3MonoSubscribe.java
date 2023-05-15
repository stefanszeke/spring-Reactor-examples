package com.example.monotutorial;

import reactor.core.publisher.Mono;

public class File3MonoSubscribe {

  public static void main(String[] args) {

    // publisher
    Mono<String> mono1 = Mono.just("Doggy");

    Mono<Integer> mono2 = Mono.just("Doggy")
        .map(s -> s.length())
        .map(l -> l / 0);

    // subscribers
    mono1.subscribe(
        data -> System.out.println("[DATA]: " + data), // onNext
        err -> System.out.println("[ERROR]: " + err.getMessage()), // onError
        () -> System.out.println("done\n") // onComplete
    );

    mono2.subscribe(
        data -> System.out.println(data), // onNext
        err -> System.out.println("[ERROR]: " + err.getMessage()), // onError
        () -> System.out.println("done\n") // onComplete
    );
  }
}
