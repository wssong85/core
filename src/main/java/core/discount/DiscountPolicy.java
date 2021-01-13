package core.discount;

import core.member.Member;

/**
 * @author wonseok.song
 * @since 2021-01-13
 */
public interface DiscountPolicy {

  /**
   * 할인 대상 금액
   * @param member
   * @param price
   * @return
   */
  int discount(Member member, int price);
}
