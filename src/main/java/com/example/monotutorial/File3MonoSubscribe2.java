package com.example.monotutorial;

import com.example.Utils.MyUtil;

import reactor.core.publisher.Mono;

public class File3MonoSubscribe2 {

  public static void main(String[] args) {

    // publisher
    Mono<String> mono1 = Mono.just("Doggy");

    Mono<Integer> mono2 = Mono.just("Doggy")
        .map(s -> s.length())
        .map(l -> l / 0);

    // subscribers
    mono1.subscribe(
        MyUtil.onNext(),
        MyUtil.onError(),
        MyUtil.onComplete());

    mono2.subscribe(
        MyUtil.onNext(),
        MyUtil.onError(),
        MyUtil.onComplete());
  }
}
