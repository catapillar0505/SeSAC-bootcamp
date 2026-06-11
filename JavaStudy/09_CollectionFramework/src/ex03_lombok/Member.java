package ex03_lombok;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 생성자
@AllArgsConstructor
// 게터세터
@Getter
@Setter
// toString()
@ToString
// equals()와 hashcode()
@EqualsAndHashCode

public class Member {
  private String name;
  private int age;

}
