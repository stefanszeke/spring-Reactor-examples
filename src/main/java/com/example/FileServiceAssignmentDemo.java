package com.example;

import com.example.Utils.MyUtil;
import com.example.assignment.FileService;

import reactor.core.publisher.Mono;

public class FileServiceAssignmentDemo {

  public static void main(String[] args) {
    System.out.println();

    FileService.read("file01.txt")
      .subscribe(
        MyUtil.onNext(),
        MyUtil.onError(),
        MyUtil.onComplete());

    FileService.write("file02.txt", "Hello Mono")
      .subscribe(
        MyUtil.onNext(),
        MyUtil.onError(),
        MyUtil.onComplete());

    FileService.read("file02.txt")
      .subscribe(
        MyUtil.onNext(),
        MyUtil.onError(),
        MyUtil.onComplete());
  }

}
