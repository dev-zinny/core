package hello.core.member;

public interface MemberService {

    // ๊ฐ์
    void join(Member member);

    // ์กฐํ
    Member findMember(Long memberId);
}
