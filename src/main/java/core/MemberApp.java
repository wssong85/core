package core;

import core.member.Grade;
import core.member.Member;
import core.member.MemberService;

/**
 * @author wonseok.song
 * @since 2021-01-12
 */
public class MemberApp {

  public static void main(String[] args) {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();

    Member member = new Member(1L, "memberA", Grade.VIP);
    memberService.join(member);

    Member findMember = memberService.findMember(1L);
    System.out.println("new member = " + member);
    System.out.println("find Member = " + findMember.getName());
  }
}
