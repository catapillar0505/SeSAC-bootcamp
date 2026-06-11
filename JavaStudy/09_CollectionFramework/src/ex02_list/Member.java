package ex02_list;

public class Member {

  // 필드
  private String name;
  private int age;

  // 생성자 2개

  public Member() {

  }

  public Member(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // 게터 세터
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  // 객체 정보 출력을 위한 toString 오버라이드
  @Override
  public String toString() {
    return "Member [name=" + name + ", age=" + age + "]";
  }

  // 객체 정보 비교를 위한 equals 오버라이드 & 해시코드

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + age;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Member other = (Member) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (age != other.age)
      return false;
    return true;
  }

}
