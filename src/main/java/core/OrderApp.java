package core;

import core.member.Grade;
import core.member.Member;
import core.member.MemberService;
import core.order.Order;
import core.order.OrderService;

/**
 * @author wonseok.song
 * @since 2021-01-13
 */
public class OrderApp {

  public static void main(String[] args) {

    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 10000);
    
    System.out.println("order = " + order);
    System.out.println("order.calculatePrice = " + order.calculatePrice());
  }
}
