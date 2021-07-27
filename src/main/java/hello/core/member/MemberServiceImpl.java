package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 인터페이스만 가지고 있으면 npe 발생.
    // 구현 객체를 선택해주어야 함.

    @Override
    public void join(Member member) {
        memberRepository.save(member);
        // 다형성에 의해서 인터페이스인 MemberRepository.save()가 아닌 MemoryMembeRespotory.save()가 호출됨.
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
