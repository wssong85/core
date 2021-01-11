package core.member;

/**
 * @author wonseok.song
 * @since 2021-01-12
 */
public interface MemberService {

  void join(Member member);

  Member findMember(Long memberId);

}
