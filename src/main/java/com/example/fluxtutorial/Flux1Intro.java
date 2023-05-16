package com.example.fluxtutorial;

import com.example.Utils.MyUtil;

import reactor.core.publisher.Flux;

public class Flux1Intro {
  public static void main(String[] args) {
    System.out.println();

    Flux<Object> flux = Flux.just("A", "B",Flux.empty() ,"C", MyUtil.faker().name().fullName());

    flux.subscribe(
      MyUtil.onNext(),
      MyUtil.onError(),
      MyUtil.onComplete());
  }
}
