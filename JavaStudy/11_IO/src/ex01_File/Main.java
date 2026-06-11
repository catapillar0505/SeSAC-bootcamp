package ex01_File;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    // 자바 홈을 파일 객체로 생성하기
    File javaHome = new File("C:/Program Files/Java/jdk-21.0.10");

    // 기본 정보 확인
    System.out.println("이름: " + javaHome.getName());
    System.out.println("절대경로: " + javaHome.getAbsolutePath());
    System.out.println("상대경로: " + javaHome.getPath());
    System.out.println(javaHome.isDirectory() ? "디렉토리" : "파일");
    System.out.println("크기: " + javaHome.length() + "Byte");
    System.out.println("최종 수정일: " + javaHome.lastModified());

    // 하위 디렉토리/파일 객체를 가져오기

    File[] files = javaHome.listFiles();
    Stream<File> stream1 = Arrays.stream(files);

    stream1
        .filter(file -> file.isFile())
        .forEach(file -> {
          System.out.println(file.getName());
          System.out.println(file.length());
        });

    // 디렉토리 조작
    File dir = new File("C:/class/JavaStudy/io_test");
    if(dir.exists()){
      System.out.println(dir.getAbsolutePath() + "존재합니다");
    }
    else{
      dir.mkdirs(); // 폴더 만들기 (mkdirs = 하위 폴더까지 만듦)
      System.out.println(dir.getAbsolutePath() + "생성하였습니다.");
    }

    dir.delete(); // 폴더 삭제 - 단 비어있는 폴더만

   
  }

}
