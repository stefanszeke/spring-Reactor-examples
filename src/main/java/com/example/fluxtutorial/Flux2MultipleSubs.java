package com.example.fluxtutorial;

import reactor.core.publisher.Flux;

public class Flux2MultipleSubs {
  
  public static void main(String[] args) {
    
    Flux<Integer> flux = Flux.range(1, 4);
    Flux<Integer> evenFlux = flux.filter(i -> i % 2 == 0);

    flux.subscribe(data -> System.out.println("Subscriber A: "+data));
    flux.subscribe(data -> System.out.println("Subscriber B: "+data));
    evenFlux.subscribe(data -> System.out.println("Subscriber C: "+data));
  }
}
