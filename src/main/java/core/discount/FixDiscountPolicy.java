package core.discount;

import core.member.Grade;
import core.member.Member;

/**
 * @author wonseok.song
 * @since 2021-01-13
 */
public class FixDiscountPolicy implements DiscountPolicy {

  private int discountFixAmount = 1000; //1000원 할인

  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.VIP) {
      return discountFixAmount;
    } else {
      return 0;
    }
  }
}
