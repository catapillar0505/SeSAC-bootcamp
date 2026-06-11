package ex04_File_util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
  // 파일복사
  public static void copy(String source, String copy) {

    // 읽을 파일의 file 객체 생성
    File src = new File(source);

    // 복사할 파일의 File 객체
    File dest = new File(copy);

    // src 읽기 -> 바이트 배열에 저장 -> dest로 보내기
    try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));) {
          byte[] b = new byte[4];
          int readByte = 0;
          while((readByte = bis.read(b)) != -1){
            bos.write(b,0,readByte);
          }
    } catch (FileNotFoundException fnfe) {
      System.err.println(fnfe.getMessage());
    } catch (IOException ioe) {
      System.err.println(ioe.getMessage());
    }
    System.out.println(dest.getAbsolutePath() + "파일 복사 완료!");
  }
}
