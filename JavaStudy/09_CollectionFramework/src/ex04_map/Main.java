package ex04_map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import lombok.val;

public class Main {
  public static void main(String[] args) {
    // 1. HashMap을 객체로 만들기
    Map<String, Object> map = new HashMap<>();

    // 2. entry 저장 (key + value = entry)
    map.put("name", "홍길동");
    map.put("age", 30);
    map.put("hobbies", new String[] { "러닝", "배드민턴", "게임" });

    // 3. Entry 수정 (기존에 사용하던 key를 다시 사용하면 - 기존 value가 수정됨)
    map.put("name", "김철수"); // 덮어쓰기 가능! 저장이건 수정이건

    // 4. key를 이용해 value 확인
    System.out.println("이름: " + map.get("name"));
    System.out.println("나이: " + map.get("age"));
    System.out.println("취미: " + Arrays.toString((String[]) map.get("hobbies")));
    System.out.println(map.getOrDefault("birthDay", "생일 정보 없음"));

    // 5. 엔트리 순회 [1] key를 이용한 순회 방식
    Set<String> keys = map.keySet();
    for (String key : keys) {
      Object value = map.get(key);
      if(value instanceof String[]){
        System.out.println("key: " + key + ", value: " + Arrays.toString((String[])value));
      }else{
        System.out.println("key: " + key + ", value: " + map.get(key));
      }
      
    }

    // 엔트리 순회 [2] 엔트리 인터페이스를 이용한 순회
    for (Map.Entry<String, Object> entry : map.entrySet()) {
      Object value = entry.getValue();
      if (value instanceof String[]) {
        System.out.println("KEY: " + entry.getKey() + " , VALUE: " + Arrays.toString((String[])value));
      } else {
        System.out.println("KEY: " + entry.getKey() + " , VALUE: " + value);
      }

    }

    // 7. Map.of()
    // 정적 팩토리 메서드 of(): new 대신 사용하는 객체생성 메서드
    // 이렇게 만든 Map 객체는 수정 불가능 (Immutable: put() 등 호출하면 오류 발생)
    // 데이터 주고받는 단계 - 데이터 훼손의 걱정이 없음

    Map<String, Object> map2 = Map.of("name","홍길동","age",30);

    System.out.println(map2);



  }

}
