package practice_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Map<String,String> map = new HashMap<>();
    map.put("apple", "사과");
    map.put("banana", "바나나");
    map.put("computer", "컴퓨터");
    map.put("dream", "꿈");
    map.put("elite", "인재");

    Scanner sc = new Scanner(System.in);
    String word = sc.next();

    if(map.containsKey(word)){
      String meaning = map.get(word);
      System.out.println(meaning);
    }else{
      System.out.println("단어장에 없다");
    }
  }
  
}
