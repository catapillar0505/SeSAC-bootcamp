package practice_03;

import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

public class Bakery {
  private int breadCount; // 빵갯수
  private int price; // 빵가격
  private int money; // 자본금

  public Bakery(int breadCount, int price, int money) {
    this.breadCount = breadCount;
    this.price = price;
    this.money = money;
  }
  public int getBreadCount() {
    return breadCount;
  }
  public void setBreadCount(int breadCount) {
    this.breadCount = breadCount;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public int getMoney() {
    return money;
  }
  public void setMoney(int money) {
    this.money = money;
  }

  public Map<String, Integer> sell (int money,int count){
     Map<String, Integer> map = null;
   try{ // 받아야할 금액
    int price = this.price * count;

    // 판매할 빵의 갯수 부족한 경우 
    if(this.breadCount < count){
      throw new RuntimeException("빵 개수 부족");
    }

    // 고객이 빵가격보다 적은 돈을 지불한 경우
    if(money < price){
      throw new RuntimeException("지불 금액 부족");
    }

    // 빵 판매
    this.breadCount -= count;

    int change = money - ( count * this.price);
    
    // 수익 정산
    this.money += price * count;
    map = Map.of("count", count, "change", change);}
    catch(Exception e){
      System.out.println(e.getMessage());
    }
    return map;        
  }
  
}
