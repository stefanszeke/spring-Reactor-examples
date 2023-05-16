package com.example.fluxtutorial;

import com.example.Utils.MyUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Flux9FluxFromMono {
  
  public static void main(String[] args) {
    
    // flux from mono
    Mono<String> mono = Mono.just("dog");
    Flux<String> flux = Flux.from(mono);
    printFlux(flux);

    // mono from flux
    Flux<String> flux2 = Flux.just("dog", "cat", "bird");
    flux2.filter(animal -> animal.equals("cat"))
      .next()
      .subscribe(
        MyUtil.onNext(),
        MyUtil.onError(),
        MyUtil.onComplete());

  }



  private static void printFlux(Flux<String> flux) {
    flux
      .subscribe(
        MyUtil.onNext(),
        MyUtil.onError(),
        MyUtil.onComplete());
  }

}
