package ex03_input;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {

    // File 객체 (우리가 읽으려는 대상)
    File dir = new File("/storeage");
    File file = new File(dir, "test.txt");

    // 파일의 데이터를 읽는 스트림 (입력 스트림)
    // 스트림 == 통로
    try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))){ // try-with-resources문
      
      // 어떤 단위로 읽을 것인지 결정(int, byte[])
      byte[] b = new byte[4];

      // 실제로 읽은 바이트 수
      int readByte = 0;

      // 파일이 끝날때까지 읽기
      while((readByte = bis.read(b)) != -1){
        System.out.println(new String(b,0, readByte));
      }
    } catch (FileNotFoundException fnfe) {
      System.err.println(fnfe.getMessage());
    } catch (IOException ioe) {
      System.err.println(ioe.getMessage());
    }

  }

}
