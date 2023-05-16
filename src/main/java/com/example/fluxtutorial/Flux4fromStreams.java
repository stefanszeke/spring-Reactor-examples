package com.example.fluxtutorial;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.example.Utils.MyUtil;

import reactor.core.publisher.Flux;

public class Flux4fromStreams {

  public static void main(String[] args) {

    List<String> myList = Arrays.asList("a", "b", "c");
    Stream<String> myStream = myList.stream();

    // myStream
    // .filter(s -> s != null)
    // .map(String::toUpperCase)
    // .forEach(System.out::println);
    // myStream // already consumed or used
    // .forEach(System.out::println);

    Flux<String> flux = Flux.fromStream(myStream);

    flux
        .subscribe(
            MyUtil.onNext(),
            MyUtil.onError(),
            MyUtil.onComplete());

    flux // stream has already been operated upon or closed
        .subscribe(
            MyUtil.onNext(),
            MyUtil.onError(),
            MyUtil.onComplete());

            System.out.println("\ncreate new stream:");
    Flux<String> flux2 = Flux.fromStream(() -> myList.stream()); // create new stream each time

    flux2
        .subscribe(
            MyUtil.onNext(),
            MyUtil.onError(),
            MyUtil.onComplete());

    flux2
        .subscribe(
            MyUtil.onNext(),
            MyUtil.onError(),
            MyUtil.onComplete());

  }

}
