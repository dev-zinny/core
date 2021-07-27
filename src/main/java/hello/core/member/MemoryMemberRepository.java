package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    // 동시에 접근할 경우에 HashMap보다는 ConcurrentHashMap을 사용해야 함.
    // 동시성 이슈가 있을 수도 있음.
    // 실무에서는 ConcurrentHashMap 사용.

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
