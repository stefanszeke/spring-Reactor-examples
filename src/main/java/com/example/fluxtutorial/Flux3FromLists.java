package com.example.fluxtutorial;

import java.util.Arrays;
import java.util.List;

import reactor.core.publisher.Flux;

public class Flux3FromLists {
  
  public static void main(String[] args) {
    
    List<String> myList = Arrays.asList("Banana", "Cherry", "Apple");
    Integer[] myArray = {1,2,3,4,5};

    Flux.fromIterable(myList)
      .subscribe(data -> System.out.println("Subscriber A: "+data));

    Flux.fromArray(myArray)
      .subscribe(data -> System.out.println("Subscriber B: "+data));
  }
}
