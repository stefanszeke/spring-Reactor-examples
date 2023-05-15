package com.example.Utils;

import java.util.function.Consumer;

import com.github.javafaker.Faker;

public class MyUtil {

  private static final Faker faker = Faker.instance();

  public static Consumer<Object> onNext() {
    return data -> System.out.println("[DATA]: " + data);
  }

  public static Consumer<Throwable> onError() {
    return err -> System.out.println("[ERROR]: " + err.getMessage());
  }

  public static Runnable onComplete() {
    return () -> System.out.println(" -> done\n");
  }

  public static Faker faker() {
    return faker;
  }

  public static void SleepFor(int seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  
}
