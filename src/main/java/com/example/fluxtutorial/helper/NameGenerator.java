package com.example.fluxtutorial.helper;

import java.util.ArrayList;
import java.util.List;

import com.example.Utils.MyUtil;

import reactor.core.publisher.Flux;

public class NameGenerator {
  

  public static List<String> getNames(int count) {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      list.add(getName());
    }
    return list;
  }

  public static Flux<String> getNamesFast(int count) {
    return Flux.range(1, count).map(i -> getName());
  }

  private static String getName() {
    System.out.println("Generating name...");
    MyUtil.SleepFor(1);
    return MyUtil.faker().name().fullName();
  }
}
