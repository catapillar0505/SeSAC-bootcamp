package ex02_output;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {

    // File 객체 (우리가 만드려는 대상)
    File dir = new File("/storeage");
    if (!dir.exists()) {
      dir.mkdirs();
    }
    File file = new File(dir, "test.txt");

    // 파일로 데이터를 보내는 스트림 (출력 스트림)
    // 스트림 == 통로
    try(BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(file,true))){ // try-with-resources문
      // 실제로 데이터 내보내기
      int c = 'A';
      byte[] b = "pple".getBytes();
      fos.write(c);
      fos.write(b);
    } catch (FileNotFoundException fnfe) {
      System.err.println(fnfe.getMessage());
    } catch (IOException ioe) {
      System.err.println(ioe.getMessage());
    }

  }

}
