package core;

import core.discount.RateDiscountPolicy;
import core.member.MemberService;
import core.member.MemberServiceImpl;
import core.member.MemoryMemberRepository;
import core.order.OrderService;
import core.order.OrderServiceImpl;

/**
 * @author wonseok.song
 * @since 2021-01-15
 */
public class AppConfig {

  public MemberService memberService() {
    return new MemberServiceImpl(new MemoryMemberRepository());
  }

  public OrderService orderService() {
    return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
  }

}
