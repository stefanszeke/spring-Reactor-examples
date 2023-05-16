package com.example.fluxtutorial;

import java.util.List;

import com.example.Utils.MyUtil;
import com.example.fluxtutorial.helper.NameGenerator;

public class Flux7ListVsFlux {

  public static void main(String[] args) {

    System.out.println("\n generating List");
    List<String> names = NameGenerator.getNames(5);
    System.out.println("List: " + names);

    System.out.println("\n generating Flux");
    NameGenerator.getNamesFast(5).subscribe(
        MyUtil.onNext(),
        MyUtil.onError(),
        MyUtil.onComplete());

  }
}
