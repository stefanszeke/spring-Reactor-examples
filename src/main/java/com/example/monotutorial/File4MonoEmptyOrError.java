package com.example.monotutorial;

import com.example.Utils.MyUtil;

import reactor.core.publisher.Mono;

public class File4MonoEmptyOrError {

  public static void main(String[] args) {
    System.out.println();

    userRepository(3).subscribe(
        MyUtil.onNext(),
        MyUtil.onError(),
        MyUtil.onComplete());
  }

  private static Mono<String> userRepository(int userId) {
    if (userId == 1) {
      return Mono.just(MyUtil.faker().name().fullName()); // -> data
    } else if (userId == 2) {
      return Mono.empty(); // -> null
    } else {
      return Mono.error(new RuntimeException("No User found for ID: " + userId)); // -> error
    }
  }

}
