package com.example.assignment;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.example.Utils.MyUtil;

import reactor.core.publisher.Mono;

public class FileService {
  
  private static final Path FILES_PATH = Paths.get("src/main/resources/assignment/files");

  // fromSupplier -> returns a result, wont throw exception
  // fromCallable -> returns a result, can throw exception
  // fromRunnable -> returns nothing, can throw exception

  


  public static Mono<String> read(String filename) {
    return Mono.fromCallable(() -> readFile(filename));
  }

  public static Mono<Void> write(String filename, String content) {
    return Mono.fromRunnable(() -> writeFile(filename, content));
  }

  public static Mono<Void> delete(String filename) {
    return Mono.fromRunnable(() -> deleteFile(filename));
  }


  private static String readFile(String fileName) {
    try {
      return Files.readString(FILES_PATH.resolve(fileName));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private static void writeFile(String fileName, String content) {
    try {
      Files.writeString(FILES_PATH.resolve(fileName), content);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private static void deleteFile(String fileName) {
    try {
      Files.delete(FILES_PATH.resolve(fileName));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
