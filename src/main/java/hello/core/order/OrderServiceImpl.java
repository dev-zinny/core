package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // 여기서 인터페이스 뿐만 아니라 구체클래스에도 의존하고 있음. DIP 위반
    // 정책을 변경할 경우에도 소스코드를 변경해야 함. OCP 위반
    private DiscountPolicy discountPolicy; // NPE 발생 -> 누군가 구현객체 대신 생성하고 주입해주어야 함.

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
