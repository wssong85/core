package core.member;

/**
 * @author wonseok.song
 * @since 2021-01-12
 */
public interface MemberRepository {

  void save(Member member);

  Member findById(Long memberId);

}
