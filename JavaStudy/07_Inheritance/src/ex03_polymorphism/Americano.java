package ex03_polymorphism;

public class Americano extends Espresso {

  public Americano(String coffeeBean) {
    super(coffeeBean);
  }

  @Override
  public void taste() {
    System.out.println("덜쓴맛");
  }

}
