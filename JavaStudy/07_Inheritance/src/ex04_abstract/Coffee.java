package ex04_abstract;

// 추상 메서드를 포함한 추상 클래스
public abstract class Coffee {

  private String coffeeBean;

  public Coffee(String coffeeBean) {
    this.coffeeBean = coffeeBean;
  }

  // 형태가 없는 추상 메서드
  public abstract void taste();

  // 커피 정보 출력 메서드
  public void info() {
    System.out.println("원산지: " + coffeeBean);
  }

}
