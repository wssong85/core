package core.discount;

import core.member.Grade;
import core.member.Member;

/**
 * @author wonseok.song
 * @since 2021-01-14
 */
public class RateDiscountPolicy implements DiscountPolicy {

  private int discountPercent = 10;

  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.VIP) {
      return price * discountPercent / 100;
    } else {
      return 0;
    }
  }

}
