package com.example.assignment;

import java.time.Duration;

import com.example.Utils.MyUtil;

import reactor.core.publisher.Flux;

public class StockPrice {

  static int price = 100;

  public static void main(String[] args) {

    Flux<Integer> flux = Flux.range(1, 20);

    flux.interval(Duration.ofSeconds(1))
        .subscribe(
            data -> {
              price = priceChange(price);
              System.out.println("Price: " + price + "\n");
            },
            MyUtil.onError(),
            MyUtil.onComplete());

    MyUtil.SleepFor(10);
  }

  private static int priceChange(int price) {
    int change = (int) (Math.random() * (5 - 1 + 1)) + 1;
    int sign = Math.random() < 0.5 ? -1 : 1;
    if (sign == -1) {
      System.out.println("[-] Price decreased by " + change);
    } else {
      System.out.println("[+] Price increased by " + change);
    }

    return price + (change * sign);
  }
}
